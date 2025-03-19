package com.ot.restaurant.exceptions;

public class IdNullException extends Exception {
  public IdNullException() {
    super("Id Cannot be null");
  }
}
