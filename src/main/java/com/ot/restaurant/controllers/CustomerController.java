package com.ot.restaurant.controllers;

import com.ot.restaurant.entities.Customer;
import com.ot.restaurant.exceptions.CustomerNotFoundException;
import com.ot.restaurant.repositories.CustomerRepository;
import constants.Status;
import java.util.List;

public class CustomerController {
  private CustomerRepository customerRepository;

  public CustomerController(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public List<Customer> findAll() throws Exception {
    return customerRepository.findAll();
  }

  public Customer findById(Long id, Status status) throws Exception {
    return customerRepository.findById(id, status).orElseThrow(CustomerNotFoundException::new);
  }

  public void insert(Customer customer) {
    customerRepository.insert(customer);
  }

  public void update(Long id, Customer customer) throws Exception {
    customerRepository.update(id, customer);
  }

  public void deleteById(Long id, Customer customer) throws Exception {
    customerRepository.deleteById(id, customer);
  }
}
