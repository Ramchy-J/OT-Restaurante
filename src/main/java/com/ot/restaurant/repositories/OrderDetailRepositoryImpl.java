package com.ot.restaurant.repositories;

import com.ot.restaurant.entities.OrderDetail;
import com.ot.restaurant.exceptions.OrderDetailNotFoundException;
import java.util.Optional;

public class OrderDetailRepositoryImpl<E extends OrderDetail> extends GenericRepositoryImpl<E> {
  public void update(Long id, E updatedOrderDetail) throws Exception {

    super.update(id, updatedOrderDetail);

    var existingOrderDetail =
        findById(id, updatedOrderDetail.getStatus()).orElseThrow(OrderDetailNotFoundException::new);
    existingOrderDetail.setOrder(
        Optional.ofNullable(updatedOrderDetail)
            .map(OrderDetail::getOrder)
            .orElseGet(existingOrderDetail::getOrder));
    existingOrderDetail.setProduct(
        Optional.ofNullable(updatedOrderDetail)
            .map(OrderDetail::getProduct)
            .orElseGet(existingOrderDetail::getProduct));
    existingOrderDetail.setQuantity(
        Optional.ofNullable(updatedOrderDetail)
            .map(OrderDetail::getQuantity)
            .orElseGet(existingOrderDetail::getQuantity));
    existingOrderDetail.setUnitPrice(
        Optional.ofNullable(updatedOrderDetail)
            .map(OrderDetail::getUnitPrice)
            .orElseGet(existingOrderDetail::getUnitPrice));
    existingOrderDetail.setDiscount(
        Optional.ofNullable(updatedOrderDetail)
            .map(OrderDetail::getDiscount)
            .orElseGet(existingOrderDetail::getDiscount));
  }
}
