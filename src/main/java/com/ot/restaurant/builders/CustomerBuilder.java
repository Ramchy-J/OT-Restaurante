package com.ot.restaurant.builders;

import com.ot.restaurant.entities.Customer;
import constants.Status;

public class CustomerBuilder {
  private Customer customer = new Customer();

  public CustomerBuilder() {}

  public CustomerBuilder withID(Long id) {
    customer.setId(id);
    return this;
  }

  public CustomerBuilder withFirstName(String firstName) {
    customer.setFirstName(firstName);
    return this;
  }

  public CustomerBuilder withLastName(String lastName) {
    customer.setLastName(lastName);
    return this;
  }

  public CustomerBuilder withPhoneNumber(String phoneNumber) {
    customer.setPhoneNumber(phoneNumber);
    return this;
  }

  public CustomerBuilder withStatus(Status status) {
    customer.setStatus(status);
    return this;
  }

  public Customer build() {
    return this.customer;
  }
}
