package com.ot.restaurant.repositories;

import com.ot.restaurant.entities.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();
    Customer findById(Long id);
    void save(Customer customer);
    void deleteById(Long id);
}
