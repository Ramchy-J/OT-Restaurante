package com.ot.restaurant.exceptions;

public class ProductNotFoundException extends Exception {
  public ProductNotFoundException() {
    super("Product not found");
  }
}
