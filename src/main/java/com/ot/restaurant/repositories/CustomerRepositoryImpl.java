package com.ot.restaurant.repositories;

import com.ot.restaurant.entities.Customer;
import com.ot.restaurant.exceptions.CustomerStatusNotActiveException;
import constants.Status;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepositoryImpl implements CustomerRepository {
  private final List<Customer> customerList = new ArrayList<>();
  private Long nextId = 0L;

  private Long generateNextId() {
    Long currentId = nextId;
    nextId++;
    return currentId;
  }

  public List<Customer> findAll() {
    return customerList.stream()
        .filter(customer -> customer.getStatus().equals(Status.ACTIVE))
        .toList();
  }

  public Optional<Customer> findById(Long id, Status status)
      throws CustomerStatusNotActiveException {
    if (status == null) {
      return (Optional<Customer>)
          Optional.empty().orElseThrow(CustomerStatusNotActiveException::new);
    } else if (status == Status.DELETED) {
      return Optional.ofNullable(
          customerList.stream()
              .filter(customer -> customer.getId().equals(id))
              .filter(customer -> customer.getStatus().equals(Status.DELETED))
              .findFirst()
              .orElseThrow(CustomerStatusNotActiveException::new));
    } else {
      return customerList.stream()
          .filter(customer -> customer.getId().equals(id))
          .filter(customer -> customer.getStatus().equals(Optional.ofNullable(status).orElse(Status.ACTIVE)))
          .findFirst();
    }
  }

  public void save(Long id, Customer customer) throws Exception {
    if (id == null) {
      insert(customer);
    } else {
      update(id, customer);
    }
  }

  public void insert(Customer customer) {
    customer.setId(generateNextId());
    customerList.add(customer);
  }

  public void update(Long id, Customer updatedCustomer) throws Exception {
    var existingCustomer =
        findById(id, updatedCustomer.getStatus())
            .orElseThrow(CustomerStatusNotActiveException::new);
    existingCustomer.setFirstName(
        Optional.ofNullable(updatedCustomer)
            .map(Customer::getFirstName)
            .orElse(existingCustomer.getFirstName()));
    existingCustomer.setLastName(
            Optional.ofNullable(updatedCustomer)
                    .map(Customer::getLastName)
                    .orElse(existingCustomer.getLastName()));
    existingCustomer.setCreatedBy(
            Optional.ofNullable(updatedCustomer)
                    .map(Customer::getCreatedBy)
                    .orElse(existingCustomer.getCreatedBy()));
    existingCustomer.setUpdatedBy(
            Optional.ofNullable(updatedCustomer)
                    .map(Customer::getUpdatedBy)
                    .orElse(existingCustomer.getUpdatedBy()));
    existingCustomer.setPhoneNumber(
            Optional.ofNullable(updatedCustomer)
                    .map(Customer::getPhoneNumber)
                    .orElse(existingCustomer.getPhoneNumber()));
    existingCustomer.setCreatedDate(
            Optional.ofNullable(updatedCustomer)
                    .map(Customer::getCreatedDate)
                    .orElse(existingCustomer.getCreatedDate()));
    existingCustomer.setUpdatedDate(
            Optional.ofNullable(updatedCustomer)
                    .map(Customer::getUpdatedDate)
                    .orElse(existingCustomer.getUpdatedDate()));
  }

  public void deleteById(Long id, Customer customer) throws Exception {
    findById(id, customer.getStatus());
    customer.setStatus(Status.DELETED);
    update(id, customer);
  }
}
