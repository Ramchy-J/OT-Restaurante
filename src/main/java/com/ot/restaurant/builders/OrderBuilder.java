package com.ot.restaurant.builders;

import com.ot.restaurant.entities.Customer;
import com.ot.restaurant.entities.Order;
import com.ot.restaurant.entities.OrderDetail;
import java.util.List;

public class OrderBuilder {
  private Order order = new Order();

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

  public Order build() {

    return order;
  }
}
