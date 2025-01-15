package com.ot.restaurant.repositories;

import static org.junit.jupiter.api.Assertions.*;

import com.ot.restaurant.entities.Customer;
import com.ot.restaurant.exceptions.CustomerStatusNotActiveException;
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

  private Customer createCustomer(String firstName) {
    Customer customer = new Customer();
    customer.setFirstName(firstName);
    customer.setStatus(Status.ACTIVE);
    return customer;
  }

  @BeforeEach
  void setUp() throws Exception {
    customerListTest.add(createCustomer("Loki0"));
    customerRepository.save(customerListTest.get(0).getId(), customerListTest.get(0));
    customerListTest.add(createCustomer("Loki1"));
    customerRepository.save(customerListTest.get(1).getId(), customerListTest.get(1));
    customerListTest.add(createCustomer("Loki2"));
    customerRepository.save(customerListTest.get(2).getId(), customerListTest.get(2));
  }

  @Test
  void shouldReturnTheCustomerListWhenFindAll() {
    assertEquals(customerListTest, customerRepository.findAll());
  }

  @Test
  void shouldReturnSpecificCustomerWhenFindByIdAndStatusActive() throws Exception {
    Customer customer = new Customer();
    customer.setFirstName("Samahia");
    customer.setStatus(Status.DELETED);
    customerRepository.save(customer.getId(), customer);
    assertEquals(
        customer, customerRepository.findById(customer.getId(), customer.getStatus()).get());

    System.out.println(
        customerRepository.findById(customer.getId(), customer.getStatus()).get().getFirstName());
  }

  @Test
  void shouldThrowsExceptionWhenStatusNotActive() throws Exception {
    Customer customer = new Customer();
    customer.setFirstName("Samahia");
    customerRepository.save(customer.getId(), customer);
    assertThrows(
        CustomerStatusNotActiveException.class,
        () -> {
          customerRepository.findById(customer.getId(), customer.getStatus());
        });
  }

  @Test
  void shouldSaveCustomerWhenSave() throws Exception {
    Customer customer = new Customer();
    customer.setFirstName("Samahia1");
    customer.setStatus(Status.ACTIVE);
    customerRepository.save(customer.getId(), customer);
    assertEquals(
        customer, customerRepository.findById(customer.getId(), customer.getStatus()).get());
    System.out.println(
        customerRepository.findById(customer.getId(), customer.getStatus()).get().getFirstName());
  }

  @Test
  void shouldSetStatusToDeletedWhenDeleteById() throws Exception {
    Customer customer = new Customer();
    customer.setFirstName("Samaia1");
    customer.setStatus(Status.ACTIVE);
    customerRepository.save(customer.getId(), customer);
    customerRepository.deleteById(customer.getId(), customer);
    assertEquals(
        Status.DELETED,
        customerRepository.findById(customer.getId(), customer.getStatus()).get().getStatus());
  }
}
