package com.ot.restaurant.repositories;

import static org.junit.jupiter.api.Assertions.*;

import com.ot.restaurant.entities.Customer;
import constants.Status;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerRepositoryImplTest {
  private CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
  private List<Customer> customerListTest = new ArrayList<>();
  private final String firstName = "Loki1";
  private final String secondName = "Loki2";
  private final String thirdName = "Loki3";

  @BeforeEach
  void setUp() {
    Customer customer = new Customer();
    customer.setFirstName(firstName);
    customerListTest.add(customer);
    customerRepository.save(customer);
    customer = new Customer();
    customer.setFirstName(secondName);
    customerListTest.add(customer);
    customerRepository.save(customer);
    customer = new Customer();
    customer.setFirstName(thirdName);
    customerListTest.add(customer);
    customerRepository.save(customer);
    // System.out.println(customer);
  }

  @Test
  void shouldReturnTheCustomerListWhenFindAll() {
    assertEquals(customerListTest, customerRepository.findAll());
  }

  @Test
  void shouldReturnSpecificCustomerWhenFindById() {
    Customer customer = new Customer();
    //customer.setFirstName("Samahia");
    customerRepository.save(customer);
    assertEquals(customer, customerRepository.findById(customer.getId()));
    System.out.println(customerRepository.findById(customer.getId()).getFirstName());
  }

  @Test
  void shouldSaveCustomerWhenSave() {
    Customer customer = new Customer();
    customer.setFirstName("Samahia1");
    customerRepository.save(customer);
    assertEquals(customer, customerRepository.findById(customer.getId()));
    System.out.println(customerRepository.findById(customer.getId()));
  }

  @Test
  void shouldSetStatusToDeletedWhenDeleteById() {
    Customer customer = new Customer();
    customer.setFirstName("Samaia2");
    customerRepository.save(customer);
    customerRepository.deleteById(customer.getId());
    assertEquals(Status.DELETED, customerRepository.findById(customer.getId()).getStatus());
  }
}
