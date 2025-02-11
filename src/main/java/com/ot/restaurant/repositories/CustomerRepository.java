package com.ot.restaurant.repositories;

import com.ot.restaurant.entities.Customer;
import constants.Status;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
  List<Customer> findAll() throws Exception;

  Optional<Customer> findById(Long id, Status status) throws Exception;

  void insert(Customer customer);

  void update(Long id, Customer customer) throws Exception;

  void deleteById(Long id, Customer customer) throws Exception;
}
