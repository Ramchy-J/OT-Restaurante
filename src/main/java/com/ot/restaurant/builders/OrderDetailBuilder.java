package com.ot.restaurant.builders;

import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.Order;
import com.ot.restaurant.entities.OrderDetail;
import com.ot.restaurant.entities.Product;

public class OrderDetailBuilder {
  private OrderDetail orderDetail = new OrderDetail();

  public static OrderDetailBuilder create() {
    return new OrderDetailBuilder();
  }

  public OrderDetailBuilder withOrder(Order order) {
    orderDetail.setOrder(order);
    return this;
  }

  public OrderDetailBuilder withProduct(Product product) {
    orderDetail.setProduct(product);
    return this;
  }

  public OrderDetailBuilder withQuantity(Integer quantity) {
    orderDetail.setQuantity(quantity);
    return this;
  }

  public OrderDetailBuilder withUnitPrice(Double unitPrice) {
    orderDetail.setUnitPrice(unitPrice);
    return this;
  }

  public OrderDetailBuilder withDiscount(Double discount) {
    orderDetail.setDiscount(discount);
    return this;
  }

  public OrderDetailBuilder withStatus(Status status) {
    orderDetail.setStatus(status);
    return this;
  }

  public OrderDetail build() {
    final var newOrderDetail = new OrderDetail();
    newOrderDetail.setId(this.orderDetail.getId());
    newOrderDetail.setOrder(this.orderDetail.getOrder());
    newOrderDetail.setProduct(this.orderDetail.getProduct());
    newOrderDetail.setQuantity(this.orderDetail.getQuantity());
    newOrderDetail.setUnitPrice(this.orderDetail.getUnitPrice());
    newOrderDetail.setDiscount(this.orderDetail.getDiscount());
    newOrderDetail.setStatus(this.orderDetail.getStatus());

    return newOrderDetail;
  }
}
