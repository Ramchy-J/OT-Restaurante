package com.ot.restaurant.builders;

import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.Customer;
import com.ot.restaurant.entities.Order;
import com.ot.restaurant.entities.OrderDetail;
import java.util.List;

public class OrderBuilder {
  private Order order = new Order();

  public static OrderBuilder create() {
    return new OrderBuilder();
  }

  public OrderBuilder withId(Long id) {
    order.setId(id);
    return this;
  }

  public OrderBuilder withCustomerInfo(Customer customerInfo) {
    order.setCustomerInfo(customerInfo);
    return this;
  }

  public OrderBuilder withOrderDetail(List<OrderDetail> orderDetails) {
    order.setOrderDetails(orderDetails);
    return this;
  }

  public OrderBuilder withTotalAmount(Double totalAmount) {
    order.setTotalAmount(totalAmount);
    return this;
  }

  public OrderBuilder withStatus(Status status) {
    order.setStatus(status);
    return this;
  }

  public Order build() {
    final var newOrder = new Order();
    newOrder.setId(this.order.getId());
    newOrder.setCustomerInfo(this.order.getCustomerInfo());
    newOrder.setOrderDetails(this.order.getOrderDetails());
    newOrder.setTotalAmount(this.order.getTotalAmount());
    newOrder.setStatus(this.order.getStatus());

    return newOrder;
  }
}
