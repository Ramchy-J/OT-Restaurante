package com.ot.restaurant.controllers;

import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.Product;
import com.ot.restaurant.exceptions.ProductNotFoundException;
import com.ot.restaurant.repositories.ProductRepository;
import java.util.List;

public class ProductController {

  private ProductRepository<Product> productRepository;

  public ProductController(ProductRepository<Product> productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> findAll() throws Exception {
    return productRepository.findAll();
  }

  public Product findById(Long id, Status status) throws Exception {
    return productRepository.findById(id, status).orElseThrow(ProductNotFoundException::new);
  }

  public void insert(Product product) throws Exception {
    productRepository.insert(product);
  }

  public void update(Long id, Product product) throws Exception {
    productRepository.update(id, product);
  }

  public void deleteById(Long id, Product product) throws Exception {
    productRepository.deleteById(id, product);
  }
}
