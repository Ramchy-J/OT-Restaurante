package com.restaurante.exceptions;

public class DependencyNotFoundException extends Exception {
  public DependencyNotFoundException() {
    super("Dependency Value does not exists");
  }
}
