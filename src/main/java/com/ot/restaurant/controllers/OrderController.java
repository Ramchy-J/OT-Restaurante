package com.ot.restaurant.controllers;

import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.Order;
import com.ot.restaurant.exceptions.OrderNotFoundException;
import com.ot.restaurant.repositories.OrderRepository;
import java.util.List;

public class OrderController {

  private OrderRepository<Order> orderRepository;

  public OrderController(OrderRepository<Order> orderRepository) {
    this.orderRepository = orderRepository;
  }

  public List<Order> findAll() throws Exception {
    return orderRepository.findAll();
  }

  public Order findById(Long id, Status status) throws Exception {
    return orderRepository.findById(id, status).orElseThrow(OrderNotFoundException::new);
  }

  public void insert(Order order) throws Exception {
    orderRepository.insert(order);
  }

  public void update(Long id, Order order) throws Exception {
    orderRepository.update(id, order);
  }

  public void deleteById(Long id, Order order) throws Exception {
    orderRepository.deleteById(id, order);
  }
}
