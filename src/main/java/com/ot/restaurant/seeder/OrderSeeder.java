package com.ot.restaurant.seeder;

import com.ot.restaurant.builders.OrderBuilder;
import com.ot.restaurant.entities.Customer;
import com.ot.restaurant.entities.Order;
import com.ot.restaurant.ioc.IoCContainer;
import com.ot.restaurant.repositories.OrderRepository;
import java.util.List;

public class OrderSeeder extends AbstractSeeder<Order> {

  private final OrderRepository orderRepository;

  private final IoCContainer ioc = IoCContainer.getInstance();

  public OrderSeeder(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  @Override
  public List<Order> load() throws Exception {
    final var customer1 = ioc.resolve("Loki1");
    final var customer2 = ioc.resolve("Loki2");
    final var customer3 = ioc.resolve("Loki3");

    return List.of(
        OrderBuilder.create().withCustomerInfo((Customer) customer1).build(),
        OrderBuilder.create().withCustomerInfo((Customer) customer2).build(),
        OrderBuilder.create().withCustomerInfo((Customer) customer3).build());
  }

  @Override
  public void save(List<Order> orderEntities) {
    orderEntities.forEach(orderRepository::insert);
  }
}
