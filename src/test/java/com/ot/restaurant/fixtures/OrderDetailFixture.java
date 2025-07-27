package com.ot.restaurant.fixtures;

import com.ot.restaurant.builders.OrderBuilder;
import com.ot.restaurant.builders.OrderDetailBuilder;
import com.ot.restaurant.builders.ProductBuilder;
import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.OrderDetail;
import java.util.Optional;

public class OrderDetailFixture {
  public static OrderDetail buildDefaultOrderDetail() {
    final var order = OrderBuilder.create().build();
    final var product = ProductBuilder.create().build();
    final var orderDetail =
        OrderDetailBuilder.create()
            .withOrder(order)
            .withProduct(product)
            .withQuantity(10)
            .withUnitPrice(50.0)
            .withDiscount(0.10)
            .build();
    return orderDetail;
  }

  public static OrderDetail buildOrderDetailFromExample(OrderDetail orderDetailExample) {
    final var order = OrderBuilder.create().build();
    final var orderDetail =
        OrderDetailBuilder.create()
            .withQuantity(
                Optional.ofNullable(orderDetailExample).map(OrderDetail::getQuantity).orElse(00))
            .withStatus(
                Optional.ofNullable(orderDetailExample)
                    .map(OrderDetail::getStatus)
                    .orElse(Status.ACTIVE))
            .build();
    return orderDetail;
  }
}
