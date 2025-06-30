package com.ot.restaurant.exceptions;

public class OrderDetailNotFoundException extends Exception {
  public OrderDetailNotFoundException() {
    super("Order detail not found");
  }
}
