package com.ot.restaurant.exceptions;

public class IngredientsNotFoundException extends Exception {
  public IngredientsNotFoundException() {
    super("Ingredients not found");
  }
}
