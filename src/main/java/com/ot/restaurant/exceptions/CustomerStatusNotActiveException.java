package com.ot.restaurant.exceptions;

public class CustomerStatusNotActiveException extends Exception {
  public CustomerStatusNotActiveException() {
    super("Customer status should be Active");
  }
}
