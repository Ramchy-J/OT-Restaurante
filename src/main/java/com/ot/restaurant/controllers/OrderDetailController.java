package com.ot.restaurant.controllers;

import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.OrderDetail;
import com.ot.restaurant.exceptions.OrderDetailNotFoundException;
import com.ot.restaurant.repositories.OrderDetailRepository;
import java.util.List;

public class OrderDetailController {

  private OrderDetailRepository<OrderDetail> orderDetailRepository;

  public OrderDetailController(OrderDetailRepository<OrderDetail> orderDetailRepository) {
    this.orderDetailRepository = orderDetailRepository;
  }

  public List<OrderDetail> findAll() throws Exception {
    return orderDetailRepository.findAll();
  }

  public OrderDetail findById(Long id, Status status) throws Exception {
    return orderDetailRepository
        .findById(id, status)
        .orElseThrow(OrderDetailNotFoundException::new);
  }

  public void insert(OrderDetail orderDetail) throws Exception {
    orderDetailRepository.insert(orderDetail);
  }

  public void update(Long id, OrderDetail orderDetail) throws Exception {
    orderDetailRepository.update(id, orderDetail);
  }

  public void deleteById(Long id, OrderDetail orderDetail) throws Exception {
    orderDetailRepository.deleteById(id, orderDetail);
  }
}
