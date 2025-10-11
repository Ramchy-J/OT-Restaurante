package com.ot.restaurant.seeder;

import com.ot.restaurant.builders.OrderBuilder;
import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.Customer;
import com.ot.restaurant.entities.Order;
import com.ot.restaurant.entities.OrderDetail;
import com.ot.restaurant.ioc.IoCContainer;
import com.ot.restaurant.repositories.CustomerRepository;
import com.ot.restaurant.repositories.OrderDetailRepository;
import com.ot.restaurant.repositories.OrderRepository;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderSeeder extends AbstractSeeder<Order> {

  private final OrderRepository orderRepository;

  public OrderSeeder(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Override
  public List<Order> load() throws Exception {
    final IoCContainer ioc = IoCContainer.getInstance();

    final var customerRepository = ((CustomerRepository) ioc.resolve("customerRepository"));

    final List<Customer> customerList = customerRepository.findAll();

    final var orderDetailRepository =
        ((OrderDetailRepository) ioc.resolve("orderDetailRepository"));

    final List<OrderDetail> orderDetailList = orderDetailRepository.findAll();

    final Map<Long, List<OrderDetail>> orderDetailMap =
        orderDetailList.stream()
            .collect(Collectors.groupingBy(orderDetail -> orderDetail.getOrder().getId()));

    return List.of(
        OrderBuilder.create()
            .withCustomerInfo((Customer) customerList.get(0))
            .withOrderDetail(orderDetailMap.get(0L))
            .withTotalAmount(calculateTotalAmount(orderDetailMap.get(0L)))
            .withStatus(Status.ACTIVE)
            .build(),
        OrderBuilder.create()
            .withCustomerInfo((Customer) customerList.get(1))
            .withOrderDetail(orderDetailMap.get(1L))
            .withTotalAmount(calculateTotalAmount(orderDetailMap.get(1L)))
            .withStatus(Status.ACTIVE)
            .build(),
        OrderBuilder.create()
            .withCustomerInfo((Customer) customerList.get(2))
            .withOrderDetail(orderDetailMap.get(2L))
            .withTotalAmount(calculateTotalAmount(orderDetailMap.get(2L)))
            .withStatus(Status.ACTIVE)
            .build());
  }

  private double calculateTotalAmount(List<OrderDetail> orderDetailList) {
    double total =
        orderDetailList.stream()
            .mapToDouble(
                detail ->
                    detail.getQuantity() * (detail.getUnitPrice() * (1 - detail.getDiscount())))
            .sum();

    return total;
  }

  @Override
  public void save(List<Order> orderEntities) {
    orderEntities.forEach(orderRepository::insert);
  }
}
