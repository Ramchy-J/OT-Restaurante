package com.ot.restaurant.fixtures;

import com.ot.restaurant.entities.Customer;
import com.ot.restaurant.entities.Order;
import com.ot.restaurant.entities.OrderDetail;
import constants.Status;
import java.util.List;
import java.util.Optional;

public class OrderFixture {
  public static Order buildDefaultOrder(Customer customer, List<OrderDetail> orderDetailList) {
    final var order = new Order();
    order.setCustomerInfo(customer);
    order.setOrderDetails(orderDetailList);
    order.setTotalAmount(1500.0);
    order.setStatus(Status.ACTIVE);
    return order;
  }

  public static Order buildOrderFromExample(Order orderExample) {
    final var order = new Order();
    final var customer = CustomerFixture.builDefaultCustomer();
    order.setCustomerInfo(
        Optional.ofNullable(orderExample).map(Order::getCustomerInfo).orElse(customer));
    order.setStatus(Optional.ofNullable(orderExample).map(Order::getStatus).orElse(Status.ACTIVE));
    return order;
  }
}
