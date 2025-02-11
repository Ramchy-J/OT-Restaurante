package com.ot.restaurant.fixtures;

import com.ot.restaurant.entities.Customer;
import constants.Status;
import java.util.Optional;

public class CustomerFixture {
  public static Customer builDefaultCustomer() {
    Customer customer = new Customer();
    customer.setFirstName("Loki1");
    customer.setStatus(Status.ACTIVE);
    return customer;
  }

  public static Customer buildCustomerFromExample(Customer customerExample) {
    Customer customer = new Customer();
    customer.setFirstName(
        Optional.ofNullable(customerExample).map(Customer::getFirstName).orElse("DefaultName"));
    customer.setStatus(
        Optional.ofNullable(customerExample).map(Customer::getStatus).orElse(Status.ACTIVE));

    return customer;
  }
}
