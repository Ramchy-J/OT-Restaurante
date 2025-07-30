package com.ot.restaurant.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

import com.ot.restaurant.builders.ProductBuilder;
import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.Product;
import com.ot.restaurant.exceptions.IdNullException;
import com.ot.restaurant.fixtures.ProductFixture;
import com.ot.restaurant.repositories.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductControllerTest {

  private ProductRepository productRepositorySpy = spy(ProductRepository.class);
  private ProductController productController = new ProductController(productRepositorySpy);
  private List<Product> productListTest = new ArrayList<>();

  @BeforeEach
  void setUp() throws Exception {}

  @Test
  void shouldReturnTheProductListWhenFindAll() throws Exception {
    when(productRepositorySpy.findAll()).thenReturn(new ArrayList<>());

    productController.findAll();

    verify(productRepositorySpy, times(1)).findAll();
  }

  @Test
  void shouldReturnSpecificProductWhenFindByIdAndStatusActive() throws Exception {

    when(productRepositorySpy.findById(1L, Status.ACTIVE)).thenReturn(Optional.empty());

    productRepositorySpy.findById(1L, Status.ACTIVE);

    verify(productRepositorySpy, times(1)).findById(1L, Status.ACTIVE);
  }

  @Test
  void shouldTrowsExceptionWhenFindByIdWithNullId() throws Exception {
    when(productRepositorySpy.findById(null, Status.ACTIVE)).thenThrow(IdNullException.class);

    verify(productRepositorySpy, times(0)).findById(null, Status.ACTIVE);
  }

  @Test
  void shouldAddProductWhenInsert() throws Exception {
    final var newProduct =
        ProductFixture.buildProductFromExample(ProductBuilder.create().withName("Samahia").build());
    productListTest.add(newProduct);

    doNothing().when(productRepositorySpy).insert(newProduct);
    productController.insert(newProduct);
    verify(productRepositorySpy, times(1)).insert(newProduct);
  }

  @Test
  void shouldSetStatusToDeletedWhenDeleteById() throws Exception {
    final var newProduct =
        ProductFixture.buildProductFromExample(ProductBuilder.create().withName("Samahia").build());
    productListTest.add(newProduct);
    final var existingProduct = productListTest.getLast();

    doNothing().when(productRepositorySpy).deleteById(existingProduct.getId(), existingProduct);
    productController.deleteById(existingProduct.getId(), existingProduct);
    verify(productRepositorySpy, times(1)).deleteById(existingProduct.getId(), existingProduct);
  }
}
