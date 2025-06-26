package com.ot.restaurant.fixtures;

import com.ot.restaurant.builders.CustomerBuilder;
import com.ot.restaurant.entities.Customer;
import constants.Status;
import java.util.Optional;

public class CustomerFixture {
  public static Customer builDefaultCustomer() {
    final var customer = new CustomerBuilder().withFirstName("DefaultName").build();
    customer.setStatus(Status.ACTIVE);
    return customer;
  }

  public static Customer buildCustomerFromExample(Customer customerExample) {
    final var customer =
        new CustomerBuilder()
            .withFirstName(
                Optional.ofNullable(customerExample)
                    .map(Customer::getFirstName)
                    .orElse("DefaultName"))
            .build();
    customer.setStatus(
        Optional.ofNullable(customerExample).map(Customer::getStatus).orElse(Status.ACTIVE));

    return customer;
  }
}
