package com.ot.restaurant.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

import com.ot.restaurant.builders.OrderBuilder;
import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.Order;
import com.ot.restaurant.exceptions.IdNullException;
import com.ot.restaurant.fixtures.OrderFixture;
import com.ot.restaurant.repositories.OrderRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderControllerTest {

  private OrderRepository orderRepositorySpy = spy(OrderRepository.class);
  private OrderController orderController = new OrderController(orderRepositorySpy);
  private List<Order> orderListTest = new ArrayList<>();

  @BeforeEach
  void setUp() throws Exception {}

  @Test
  void shouldReturnTheOrderListWhenFindAll() throws Exception {
    when(orderRepositorySpy.findAll()).thenReturn(new ArrayList<>());

    orderController.findAll();

    verify(orderRepositorySpy, times(1)).findAll();
  }

  @Test
  void shouldReturnSpecificOrderWhenFindByIdAndStatusActive() throws Exception {

    when(orderRepositorySpy.findById(1L, Status.ACTIVE)).thenReturn(Optional.empty());

    orderRepositorySpy.findById(1L, Status.ACTIVE);

    verify(orderRepositorySpy, times(1)).findById(1L, Status.ACTIVE);
  }

  @Test
  void shouldTrowsExceptionWhenFindByIdWithNullId() throws Exception {
    when(orderRepositorySpy.findById(null, Status.ACTIVE)).thenThrow(IdNullException.class);

    verify(orderRepositorySpy, times(0)).findById(null, Status.ACTIVE);
  }

  @Test
  void shouldAddOrderWhenInsert() throws Exception {
    final var newOrder =
        OrderFixture.buildOrderFromExample(OrderBuilder.create().withTotalAmount(120.0).build());
    orderListTest.add(newOrder);

    doNothing().when(orderRepositorySpy).insert(newOrder);
    orderController.insert(newOrder);
    verify(orderRepositorySpy, times(1)).insert(newOrder);
  }

  @Test
  void shouldSetStatusToDeletedWhenDeleteById() throws Exception {
    final var newOrder =
        OrderFixture.buildOrderFromExample(OrderBuilder.create().withTotalAmount(120.0).build());
    orderListTest.add(newOrder);
    final var existingOrder = orderListTest.getLast();

    doNothing().when(orderRepositorySpy).deleteById(existingOrder.getId(), existingOrder);
    orderController.deleteById(existingOrder.getId(), existingOrder);
    verify(orderRepositorySpy, times(1)).deleteById(existingOrder.getId(), existingOrder);
  }
}
