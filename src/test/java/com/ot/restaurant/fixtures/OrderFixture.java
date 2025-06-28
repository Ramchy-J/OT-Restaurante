package com.ot.restaurant.fixtures;

import com.ot.restaurant.builders.CustomerBuilder;
import com.ot.restaurant.builders.OrderBuilder;
import com.ot.restaurant.entities.Order;
import com.ot.restaurant.entities.OrderDetail;
import constants.Status;
import java.util.List;
import java.util.Optional;

public class OrderFixture {
  public static Order buildDefaultOrder(List<OrderDetail> orderDetailList) {
    final var customer = CustomerBuilder.create().build();
    final var order =
        OrderBuilder.create()
            .withCustomerInfo(customer)
            .withOrderDetail(orderDetailList)
            .withTotalAmount(1500.0)
            .build();
    order.setStatus(Status.ACTIVE);
    return order;
  }

  public static Order buildOrderFromExample(Order orderExample) {

    final var customer = CustomerFixture.builDefaultCustomer();
    final var order =
        OrderBuilder.create()
            .withCustomerInfo(
                Optional.ofNullable(orderExample).map(Order::getCustomerInfo).orElse(customer))
            .withStatus(
                Optional.ofNullable(orderExample).map(Order::getStatus).orElse(Status.ACTIVE))
            .build();
    return order;
  }
}
