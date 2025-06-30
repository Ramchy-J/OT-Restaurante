package com.ot.restaurant.repositories;

import com.ot.restaurant.entities.Order;
import com.ot.restaurant.exceptions.OrderNotFoundException;
import java.util.Optional;

public class OrderRepositoryImpl<E extends Order> extends GenericRepositoryImpl<E> {

  public void update(Long id, E updatedOrder) throws Exception {

    super.update(id, updatedOrder);

    var existingOrder =
        findById(id, updatedOrder.getStatus()).orElseThrow(OrderNotFoundException::new);
    existingOrder.setCustomerInfo(
        Optional.ofNullable(updatedOrder)
            .map(Order::getCustomerInfo)
            .orElseGet(existingOrder::getCustomerInfo));
    existingOrder.setOrderDetails(
        Optional.ofNullable(updatedOrder)
            .map(Order::getOrderDetails)
            .orElseGet(existingOrder::getOrderDetails));
    existingOrder.setTotalAmount(
        Optional.ofNullable(updatedOrder)
            .map(Order::getTotalAmount)
            .orElseGet(existingOrder::getTotalAmount));
  }
}
