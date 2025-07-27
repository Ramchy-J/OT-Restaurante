package com.ot.restaurant.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.ot.restaurant.builders.CustomerBuilder;
import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.Customer;
import com.ot.restaurant.exceptions.IdNullException;
import com.ot.restaurant.fixtures.CustomerFixture;
import com.ot.restaurant.repositories.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerControllerTest {

  private CustomerRepository customerRepositorySpy = spy(CustomerRepository.class);
  private CustomerController customerController = new CustomerController(customerRepositorySpy);
  private List<Customer> customerListTest = new ArrayList<>();

  @BeforeEach
  void setUp() throws Exception {}

  @Test
  void shouldReturnTheCustomerListWhenFindAll() throws Exception {
    when(customerRepositorySpy.findAll()).thenReturn(new ArrayList<>());

    customerController.findAll();

    verify(customerRepositorySpy, times(1)).findAll();
  }

  @Test
  void shouldReturnSpecificCustomerWhenFindByIdAndStatusActive() throws Exception {

    when(customerRepositorySpy.findById(1L, Status.ACTIVE)).thenReturn(Optional.empty());

    customerRepositorySpy.findById(1L, Status.ACTIVE);

    verify(customerRepositorySpy, times(1)).findById(1L, Status.ACTIVE);
  }

  @Test
  void shouldTrowsExceptionWhenFindByIdWithNullId() throws Exception {
    when(customerRepositorySpy.findById(null, Status.ACTIVE)).thenThrow(IdNullException.class);

    verify(customerRepositorySpy, times(0)).findById(null, Status.ACTIVE);
  }

  @Test
  void shouldAddCustomerWhenInsert() throws Exception {
    final var newCustomer =
        CustomerFixture.buildCustomerFromExample(
            CustomerBuilder.create().withFirstName("Samahia").build());
    customerListTest.add(newCustomer);

    doNothing().when(customerRepositorySpy).insert(newCustomer);
    customerController.insert(newCustomer);
    verify(customerRepositorySpy, times(1)).insert(newCustomer);
  }

  @Test
  void shouldSetStatusToDeletedWhenDeleteById() throws Exception {
    final var newCustomer =
        CustomerFixture.buildCustomerFromExample(
            CustomerBuilder.create().withFirstName("Samahia").build());
    customerListTest.add(newCustomer);
    final var existingCustomer = customerListTest.getLast();

    doNothing().when(customerRepositorySpy).deleteById(existingCustomer.getId(), existingCustomer);
    customerController.deleteById(existingCustomer.getId(), existingCustomer);
    verify(customerRepositorySpy, times(1)).deleteById(existingCustomer.getId(), existingCustomer);
  }
}
