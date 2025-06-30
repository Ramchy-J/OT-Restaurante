package com.ot.restaurant.exceptions;

public class OrderNotFoundException extends Exception {
  public OrderNotFoundException() {
    super("Order not found");
  }
}
