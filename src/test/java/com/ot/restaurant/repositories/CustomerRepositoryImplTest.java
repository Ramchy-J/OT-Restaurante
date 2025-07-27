package com.ot.restaurant.repositories;

import static org.junit.jupiter.api.Assertions.*;

import com.ot.restaurant.builders.CustomerBuilder;
import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.Customer;
import com.ot.restaurant.exceptions.IdNullException;
import com.ot.restaurant.fixtures.CustomerFixture;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerRepositoryImplTest {
  private CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
  private List<Customer> customerListTest = new ArrayList<>();

  @BeforeEach
  void setUp() throws Exception {

    final var customers =
        List.of(
            CustomerFixture.buildCustomerFromExample(
                CustomerBuilder.create().withFirstName("Loki1").build()),
            CustomerFixture.buildCustomerFromExample(
                CustomerBuilder.create().withFirstName("Loki2").build()),
            CustomerFixture.buildCustomerFromExample(
                CustomerBuilder.create().withFirstName("Loki3").build()));
    customers.forEach(customerRepository::insert);
    customerListTest.addAll(customers);
  }

  @Test
  void shouldReturnTheCustomerListWhenFindAll() {

    assertEquals(customerListTest, customerRepository.findAll());
  }

  @Test
  void shouldReturnSpecificCustomerWhenFindByIdAndStatusActive() throws Exception {
    final var existingCustomer = customerRepository.findById(1L, Status.ACTIVE).get();

    assertEquals(1L, existingCustomer.getId());
    assertEquals("Loki2", existingCustomer.getFirstName());
  }

  @Test
  void shouldTrowsExceptionWhenFindByIdWithNullId() throws Exception {
    assertThrows(
        IdNullException.class,
        () -> {
          customerRepository.findById(null, Status.ACTIVE);
        });
  }

  @Test
  void shouldAddCustomerWhenInsert() throws Exception {
    final var newCustomer =
        CustomerFixture.buildCustomerFromExample(
            CustomerBuilder.create().withFirstName("Samahia").build());
    customerRepository.insert(newCustomer);
    final var existingCustomers = customerRepository.findAll();

    assertEquals(
        existingCustomers.getLast(),
        customerRepository
            .findById(existingCustomers.getLast().getId(), existingCustomers.getLast().getStatus())
            .get());
  }

  @Test
  void shouldSetStatusToDeletedWhenDeleteById() throws Exception {
    final var existingCustomers = customerRepository.findAll();
    final var existingCustomer = existingCustomers.getLast();

    customerRepository.deleteById(existingCustomer.getId(), existingCustomer);

    assertEquals(Status.DELETED, existingCustomers.getLast().getStatus());
  }
}
