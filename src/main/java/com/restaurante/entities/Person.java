package com.restaurante.entities;

import constants.Status;
import entities.Base;
import java.time.Instant;

public class Person extends Base {

  // Attributes

  private String firstName;
  private String lastName;

  // Constructor

  public Person() {}

  public Person(
      final Long id,
      final Instant createdDate,
      final Instant updatedDate,
      final Long createdBy,
      final Long updatedBy,
      final Status status,
      final String firstName,
      final String lastName) {
    super(id, createdDate, updatedDate, createdBy, updatedBy, status);
    this.firstName = firstName;
    this.lastName = lastName;
  }

  // Methods

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }
}
