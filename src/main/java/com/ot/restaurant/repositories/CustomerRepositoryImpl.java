package com.ot.restaurant.repositories;

import com.ot.restaurant.entities.Customer;
import com.ot.restaurant.exceptions.CustomerNotFoundException;
import com.ot.restaurant.exceptions.IdNullException;
import constants.Status;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

public class CustomerRepositoryImpl implements CustomerRepository {
  private final TreeMap<Long, Customer> customerMap = new TreeMap<Long, Customer>();
  private Long nextId = 0L;

  private Long generateNextId() {
    Long currentId = nextId;
    nextId++;
    return currentId;
  }

  public List<Customer> findAll() {
    return customerMap.values().stream()
        .filter(customer -> customer.getStatus().equals(Status.ACTIVE))
        .toList();
  }

  public Optional<Customer> findById(Long id, Status status) throws Exception {
    Optional.ofNullable(id).orElseThrow(IdNullException::new);

    return Optional.ofNullable(customerMap.get(id))
        .map(Optional::of)
        .orElseThrow(CustomerNotFoundException::new);
  }

  public void insert(Customer customer) {
    customer.setId(generateNextId());
    customerMap.put(customer.getId(), customer);
  }

  public void update(Long id, Customer updatedCustomer) throws Exception {
    var existingCustomer =
        findById(id, updatedCustomer.getStatus()).orElseThrow(CustomerNotFoundException::new);
    existingCustomer.setFirstName(
        Optional.ofNullable(updatedCustomer)
            .map(Customer::getFirstName)
            .orElse(existingCustomer.getFirstName()));
    existingCustomer.setLastName(
        Optional.ofNullable(updatedCustomer)
            .map(Customer::getLastName)
            .orElse(existingCustomer.getLastName()));
    existingCustomer.setUpdatedBy(
        Optional.ofNullable(updatedCustomer)
            .map(Customer::getUpdatedBy)
            .orElse(existingCustomer.getUpdatedBy()));
    existingCustomer.setPhoneNumber(
        Optional.ofNullable(updatedCustomer)
            .map(Customer::getPhoneNumber)
            .orElse(existingCustomer.getPhoneNumber()));
    existingCustomer.setUpdatedDate(
        Optional.ofNullable(updatedCustomer)
            .map(Customer::getUpdatedDate)
            .orElse(existingCustomer.getUpdatedDate()));
    existingCustomer.setStatus(
        Optional.ofNullable(updatedCustomer)
            .map(Customer::getStatus)
            .orElse(existingCustomer.getStatus()));
  }

  public void deleteById(Long id, Customer customer) throws Exception {
    final var existingCustomer = findById(id, customer.getStatus());
    existingCustomer.get().setStatus(Status.DELETED);
    update(id, customer);
  }

  public List<Customer> findAllIncludingDeleted() throws Exception {
    return customerMap.values().stream().toList();
  }
}
