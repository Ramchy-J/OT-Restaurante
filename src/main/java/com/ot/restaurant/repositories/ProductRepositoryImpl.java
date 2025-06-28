package com.ot.restaurant.repositories;

import com.ot.restaurant.entities.Product;
import com.ot.restaurant.exceptions.CustomerNotFoundException;
import java.util.Optional;

public class ProductRepositoryImpl<E extends Product> extends GenericRepositoryImpl<E> {
  public void update(Long id, E updatedProduct) throws Exception {

    super.update(id, updatedProduct);

    var existingProduct =
        findById(id, updatedProduct.getStatus()).orElseThrow(CustomerNotFoundException::new);
    existingProduct.setName(
        Optional.ofNullable(updatedProduct)
            .map(Product::getName)
            .orElseGet(existingProduct::getName));
    existingProduct.setPrice(
        Optional.ofNullable(updatedProduct)
            .map(Product::getPrice)
            .orElseGet(existingProduct::getPrice));
    existingProduct.setCategory(
        Optional.ofNullable(updatedProduct)
            .map(Product::getCategory)
            .orElseGet(existingProduct::getCategory));
    existingProduct.setIngredients(
        Optional.ofNullable(updatedProduct)
            .map(Product::getIngredients)
            .orElseGet(existingProduct::getIngredients));
  }
}
