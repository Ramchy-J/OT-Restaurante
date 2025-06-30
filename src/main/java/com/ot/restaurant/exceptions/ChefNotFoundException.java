package com.ot.restaurant.exceptions;

public class ChefNotFoundException extends Exception {
  public ChefNotFoundException() {
    super("Chef not found");
  }
}
