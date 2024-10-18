package com.restaurante.entities;

import constants.Status;
import entities.Base;
import java.time.Instant;
import java.util.List;

public class Order extends Base {
  // Attributes

  private Customer customerInfo;
  private List<OrderDetail> orderDetails;
  private Double totalAmount;

  // Constructors

  public Order() {}

  public Order(
      final Long id,
      final Instant createdDate,
      final Instant updatedDate,
      final Long createdBy,
      final Long updatedBy,
      final Status status,
      final Customer customerInfo,
      final List<OrderDetail> orderDetails,
      final Double totalAmount) {
    super(id, createdDate, updatedDate, createdBy, updatedBy, status);
    this.customerInfo = customerInfo;
    this.orderDetails = orderDetails;
    this.totalAmount = totalAmount;
  }

  // Methods

  public Customer getCustomerInfo() {
    return customerInfo;
  }

  public void setCustomerInfo(final Customer customerInfo) {
    this.customerInfo = customerInfo;
  }

  public List<OrderDetail> getOrderDetails() {
    return orderDetails;
  }

  public void setOrderDetails(final List<OrderDetail> orderDetails) {
    this.orderDetails = orderDetails;
  }

  public Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(final Double totalAmount) {
    this.totalAmount = totalAmount;
  }
}
