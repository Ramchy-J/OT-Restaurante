package com.ot.restaurant.builders;

import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.Customer;

public class CustomerBuilder {
  private Customer customer = new Customer();

  public static CustomerBuilder create() {
    return new CustomerBuilder();
  }

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
    final var newCustomer = new Customer();
    newCustomer.setId(this.customer.getId());
    newCustomer.setFirstName(this.customer.getFirstName());
    newCustomer.setLastName(this.customer.getLastName());
    newCustomer.setPhoneNumber(this.customer.getPhoneNumber());
    newCustomer.setStatus(this.customer.getStatus());

    return newCustomer;
  }
}
