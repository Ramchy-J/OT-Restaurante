package com.restaurante.exceptions;

public class DependencyValueNullpointerException extends Exception {
  public DependencyValueNullpointerException() {
    super("Value cannot be null");
  }
}
