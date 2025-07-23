package com.ot.restaurant.repositories;

import static org.junit.jupiter.api.Assertions.*;

import com.ot.restaurant.builders.OrderDetailBuilder;
import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.OrderDetail;
import com.ot.restaurant.exceptions.IdNullException;
import com.ot.restaurant.fixtures.OrderDetailFixture;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderDetailRepositoryImplTest {

  private OrderDetailRepositoryImpl<OrderDetail> orderDetailRepository =
      new OrderDetailRepositoryImpl<>();
  private List<OrderDetail> orderDetailsListTest = new ArrayList<>();

  @BeforeEach
  void setUp() throws Exception {

    final var ordersDetails =
        List.of(
            OrderDetailFixture.buildOrderDetailFromExample(
                OrderDetailBuilder.create().withQuantity(123).build()),
            OrderDetailFixture.buildOrderDetailFromExample(
                OrderDetailBuilder.create().withQuantity(456).build()),
            OrderDetailFixture.buildOrderDetailFromExample(
                OrderDetailBuilder.create().withQuantity(789).build()));
    ordersDetails.forEach(orderDetailRepository::insert);
    orderDetailsListTest.addAll(ordersDetails);
  }

  @Test
  void shouldReturnTheProductListWhenFindAll() {

    assertEquals(orderDetailsListTest, orderDetailRepository.findAll());
  }

  @Test
  void shouldReturnSpecificProductWhenFindByIdAndStatusActive() throws Exception {
    final var existingOrderDetail = orderDetailRepository.findById(1L, Status.ACTIVE).get();

    assertEquals(1L, existingOrderDetail.getId());
    assertEquals(456, existingOrderDetail.getQuantity());
  }

  @Test
  void shouldTrowsExceptionWhenFindByIdWithNullId() throws Exception {
    assertThrows(
        IdNullException.class,
        () -> {
          orderDetailRepository.findById(null, Status.ACTIVE);
        });
  }

  @Test
  void shouldAddProductWhenInsert() throws Exception {
    final var newOrderDetail =
        OrderDetailFixture.buildOrderDetailFromExample(
            OrderDetailBuilder.create().withQuantity(357).build());
    orderDetailRepository.insert(newOrderDetail);
    final var existingProducts = orderDetailRepository.findAll();

    assertEquals(
        existingProducts.getLast(),
        orderDetailRepository.findById(existingProducts.getLast().getId(), Status.ACTIVE).get());
  }

  @Test
  void shouldSetStatusToDeletedWhenDeleteById() throws Exception {
    final var existingOrdersDetails = orderDetailRepository.findAll();
    final var existingOrderDetail = existingOrdersDetails.getLast();

    orderDetailRepository.deleteById(existingOrdersDetails.getLast().getId(), existingOrderDetail);

    final var result =
        orderDetailRepository.findById(
            existingOrderDetail.getId(), existingOrderDetail.getStatus());

    assertEquals(Status.DELETED, result.get().getStatus());
  }
}
