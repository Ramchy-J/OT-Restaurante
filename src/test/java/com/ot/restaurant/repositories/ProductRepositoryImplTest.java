package com.ot.restaurant.repositories;

import static org.junit.jupiter.api.Assertions.*;

import com.ot.restaurant.builders.ProductBuilder;
import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.Product;
import com.ot.restaurant.exceptions.IdNullException;
import com.ot.restaurant.fixtures.ProductFixture;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductRepositoryImplTest {
  private ProductRepositoryImpl<Product> productRepository = new ProductRepositoryImpl<Product>();
  private List<Product> productListTest = new ArrayList<>();

  @BeforeEach
  void setUp() throws Exception {

    final var products =
        List.of(
            ProductFixture.buildProductFromExample(
                ProductBuilder.create().withName("Default1").build()),
            ProductFixture.buildProductFromExample(
                ProductBuilder.create().withName("Default2").build()),
            ProductFixture.buildProductFromExample(
                ProductBuilder.create().withName("Default3").build()));
    products.forEach(productRepository::insert);
    productListTest.addAll(products);
  }

  @Test
  void shouldReturnTheProductListWhenFindAll() {

    assertEquals(productListTest, productRepository.findAll());
  }

  @Test
  void shouldReturnSpecificProductWhenFindByIdAndStatusActive() throws Exception {
    final var existingProduct = productRepository.findById(1L, Status.ACTIVE).get();

    assertEquals(1L, existingProduct.getId());
    assertEquals("Default2", existingProduct.getName());
  }

  @Test
  void shouldTrowsExceptionWhenFindByIdWithNullId() throws Exception {
    assertThrows(
        IdNullException.class,
        () -> {
          productRepository.findById(null, Status.ACTIVE);
        });
  }

  @Test
  void shouldAddProductWhenInsert() throws Exception {
    final var newProduct =
        ProductFixture.buildProductFromExample(
            ProductBuilder.create().withName("Default4").build());
    productRepository.insert(newProduct);
    final var existingProducts = productRepository.findAll();

    assertEquals(
        existingProducts.getLast(),
        productRepository.findById(existingProducts.getLast().getId(), Status.ACTIVE).get());
  }

  @Test
  void shouldSetStatusToDeletedWhenDeleteById() throws Exception {
    final var existingProducts = productRepository.findAll();
    final var existingProduct = existingProducts.getLast();

    productRepository.deleteById(existingProducts.getLast().getId(), existingProduct);

    final var result =
        productRepository.findById(existingProduct.getId(), existingProduct.getStatus());

    assertEquals(Status.DELETED, result.get().getStatus());
  }
}
