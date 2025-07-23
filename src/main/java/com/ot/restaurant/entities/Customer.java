package com.ot.restaurant.entities;

import com.ot.restaurant.constants.Status;
import java.time.Instant;

public class Customer extends Person {
  // Attributes

  private String phoneNumber;

  // Constructors

  public Customer() {}

  public Customer(
      final Long id,
      final Instant createdDate,
      final Instant updatedDate,
      final Long createdBy,
      final Long updatedBy,
      final Status status,
      final String firstName,
      final String lastName,
      final String phoneNumber) {
    super(id, createdDate, updatedDate, createdBy, updatedBy, status, firstName, lastName);
    this.phoneNumber = phoneNumber;
  }

  // Methods

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(final String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}
