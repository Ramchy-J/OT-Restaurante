package com.ot.restaurant.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

import com.ot.restaurant.builders.OrderDetailBuilder;
import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.OrderDetail;
import com.ot.restaurant.exceptions.IdNullException;
import com.ot.restaurant.fixtures.OrderDetailFixture;
import com.ot.restaurant.repositories.OrderDetailRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderDetailControllerTest {

  private OrderDetailRepository orderDetailRepositorySpy = spy(OrderDetailRepository.class);
  private OrderDetailController orderDetailController =
      new OrderDetailController(orderDetailRepositorySpy);
  private List<OrderDetail> orderDetailListTest = new ArrayList<>();

  @BeforeEach
  void setUp() throws Exception {}

  @Test
  void shouldReturnTheOrderDetailListWhenFindAll() throws Exception {
    when(orderDetailRepositorySpy.findAll()).thenReturn(new ArrayList<>());

    orderDetailController.findAll();

    verify(orderDetailRepositorySpy, times(1)).findAll();
  }

  @Test
  void shouldReturnSpecificOrderDetailWhenFindByIdAndStatusActive() throws Exception {

    when(orderDetailRepositorySpy.findById(1L, Status.ACTIVE)).thenReturn(Optional.empty());

    orderDetailRepositorySpy.findById(1L, Status.ACTIVE);

    verify(orderDetailRepositorySpy, times(1)).findById(1L, Status.ACTIVE);
  }

  @Test
  void shouldTrowsExceptionWhenFindByIdWithNullId() throws Exception {
    when(orderDetailRepositorySpy.findById(null, Status.ACTIVE)).thenThrow(IdNullException.class);

    verify(orderDetailRepositorySpy, times(0)).findById(null, Status.ACTIVE);
  }

  @Test
  void shouldAddOrderDetailWhenInsert() throws Exception {
    final var newOrderDetail =
        OrderDetailFixture.buildOrderDetailFromExample(
            OrderDetailBuilder.create().withUnitPrice(100.0).build());
    orderDetailListTest.add(newOrderDetail);

    doNothing().when(orderDetailRepositorySpy).insert(newOrderDetail);
    orderDetailController.insert(newOrderDetail);
    verify(orderDetailRepositorySpy, times(1)).insert(newOrderDetail);
  }

  @Test
  void shouldSetStatusToDeletedWhenDeleteById() throws Exception {
    final var newOrderDetail =
        OrderDetailFixture.buildOrderDetailFromExample(
            OrderDetailBuilder.create().withUnitPrice(100.0).build());
    orderDetailListTest.add(newOrderDetail);
    final var existingOrderDetail = orderDetailListTest.getLast();

    doNothing()
        .when(orderDetailRepositorySpy)
        .deleteById(existingOrderDetail.getId(), existingOrderDetail);
    orderDetailController.deleteById(existingOrderDetail.getId(), existingOrderDetail);
    verify(orderDetailRepositorySpy, times(1))
        .deleteById(existingOrderDetail.getId(), existingOrderDetail);
  }
}
