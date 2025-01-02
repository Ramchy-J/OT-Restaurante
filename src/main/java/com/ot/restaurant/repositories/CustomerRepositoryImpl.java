package com.ot.restaurant.repositories;

import com.ot.restaurant.entities.Customer;
import constants.Status;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
  private List<Customer> customerList = new ArrayList<>();
  private Long nextId = 0L;

  public List<Customer> findAll() {
    return customerList;
  }

  public Customer findById(Long id) {
    return customerList.get(Math.toIntExact(id));
  }

  public void save(Customer customer) {
    if (customer.getId() == null) {
      customer.setId(nextId++);
      customerList.add(customer);
    } else {
      customerList.replaceAll(
          existingCustomer ->
              existingCustomer.getId().equals(customer.getId()) ? customer : existingCustomer);
    }
  }

  public void deleteById(Long id) {
    customerList.get(Math.toIntExact(id)).setStatus(Status.DELETED);
  }
}
