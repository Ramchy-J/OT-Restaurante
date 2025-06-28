package com.ot.restaurant.fixtures;

import com.ot.restaurant.builders.CustomerBuilder;
import com.ot.restaurant.entities.Customer;
import constants.Status;
import java.util.Optional;

public class CustomerFixture {
  public static Customer builDefaultCustomer() {
    final var customer =
        CustomerBuilder.create().withFirstName("DefaultName").withStatus(Status.ACTIVE).build();
    return customer;
  }

  public static Customer buildCustomerFromExample(Customer customerExample) {
    final var customer =
        CustomerBuilder.create()
            .withFirstName(
                Optional.ofNullable(customerExample)
                    .map(Customer::getFirstName)
                    .orElse("DefaultName"))
            .withStatus(
                Optional.ofNullable(customerExample).map(Customer::getStatus).orElse(Status.ACTIVE))
            .build();
    return customer;
  }
}
