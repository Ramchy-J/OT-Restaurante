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
import com.ot.restaurant.utils.OrderUtil;
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

    return orderDetailMap.entrySet().stream()
        .map(
            entry ->
                OrderBuilder.create()
                    .withId(entry.getKey())
                    .withOrderDetail(entry.getValue())
                    .withStatus(Status.ACTIVE)
                    .withCustomerInfo(customerList.get(Math.toIntExact(entry.getKey())))
                    .withTotalAmount(OrderUtil.calculateOrderTotalAmount(entry.getValue()))
                    .build())
        .toList();
  }

  @Override
  public void save(List<Order> orderEntities) {
    orderEntities.forEach(orderRepository::insert);
  }
}
