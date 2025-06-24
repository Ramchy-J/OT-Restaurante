package com.ot.restaurant.repositories;

import static org.junit.jupiter.api.Assertions.*;

import com.ot.restaurant.builders.CustomerBuilder;
import com.ot.restaurant.builders.OrderBuilder;
import com.ot.restaurant.entities.Customer;
import com.ot.restaurant.entities.Order;
import com.ot.restaurant.exceptions.IdNullException;
import com.ot.restaurant.fixtures.CustomerFixture;
import com.ot.restaurant.fixtures.OrderFixture;
import constants.Status;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderRepositoryImplTest {

  private OrderRepositoryImpl<Order> orderRepository = new OrderRepositoryImpl();
  private List<Order> orderListTest = new ArrayList<>();
  private List<Customer> customerListTest = new ArrayList<>();

  @BeforeEach
  void setUp() throws Exception {

    final var customers =
        List.of(
            CustomerFixture.buildCustomerFromExample(
                new CustomerBuilder().withFirstName("Loki1").build()),
            CustomerFixture.buildCustomerFromExample(
                new CustomerBuilder().withFirstName("Loki2").build()),
            CustomerFixture.buildCustomerFromExample(
                new CustomerBuilder().withFirstName("Loki3").build()));
    customerListTest.addAll(customers);

    final var orders =
        List.of(
            OrderFixture.buildOrderFromExample(
                new OrderBuilder().withCustomerInfo(customerListTest.get(0)).build()),
            OrderFixture.buildOrderFromExample(
                new OrderBuilder().withCustomerInfo(customerListTest.get(1)).build()),
            OrderFixture.buildOrderFromExample(
                new OrderBuilder().withCustomerInfo(customerListTest.get(2)).build()));
    orders.forEach(orderRepository::insert);
    orderListTest.addAll(orders);
  }

  @Test
  void shouldReturnTheOrderListWhenFindAll() {

    assertEquals(orderListTest, orderRepository.findAll());
  }

  @Test
  void shouldReturnSpecificOrderWhenFindByIdAndStatusActive() throws Exception {
    final var existingOrder = orderRepository.findById(1L, Status.ACTIVE).get();
    final var customer = existingOrder.getCustomerInfo();

    assertEquals(1L, existingOrder.getId());
    assertEquals("Loki2", customer.getFirstName());
  }

  @Test
  void shouldTrowsExceptionWhenFindByIdWithNullId() throws Exception {
    assertThrows(
        IdNullException.class,
        () -> {
          orderRepository.findById(null, Status.ACTIVE);
        });
  }

  @Test
  void shouldAddOrderWhenInsert() throws Exception {
    final var customer =
        CustomerFixture.buildCustomerFromExample(
            new CustomerBuilder().withFirstName("Loki4").build());
    final var order =
        OrderFixture.buildOrderFromExample(new OrderBuilder().withCustomerInfo(customer).build());
    orderRepository.insert(order);
    final var existingOrders = orderRepository.findAll();

    assertEquals(
        existingOrders.getLast(),
        orderRepository.findById(existingOrders.getLast().getId(), Status.ACTIVE).get());
  }

  @Test
  void shouldSetStatusToDeletedWhenDeleteById() throws Exception {
    final var existingOrders = orderRepository.findAll();
    final var existingOrder = existingOrders.getLast();

    orderRepository.deleteById(existingOrders.getLast().getId(), existingOrder);

    final var result = orderRepository.findById(existingOrder.getId(), existingOrder.getStatus());

    assertEquals(Status.DELETED, result.get().getStatus());
  }
}
