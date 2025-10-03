package com.ot.restaurant.seeder;

import com.ot.restaurant.builders.OrderBuilder;
import com.ot.restaurant.builders.OrderDetailBuilder;
import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.OrderDetail;
import com.ot.restaurant.entities.Product;
import com.ot.restaurant.ioc.IoCContainer;
import com.ot.restaurant.repositories.OrderDetailRepository;
import com.ot.restaurant.repositories.ProductRepository;
import java.util.List;

public class OrderDetailSeeder extends AbstractSeeder<OrderDetail> {

  private final OrderDetailRepository orderDetailRepository;

  public OrderDetailSeeder(OrderDetailRepository orderDetailRepository) {
    this.orderDetailRepository = orderDetailRepository;
  }

  @Override
  public List<OrderDetail> load() throws Exception {

    final var ioc = IoCContainer.getInstance();

    final var productRepository = ((ProductRepository) ioc.resolve("productRepository"));

    final List<Product> productList = productRepository.findAll();

    final var order1 = OrderBuilder.create().withId(0L).build();
    final var order2 = OrderBuilder.create().withId(1L).build();
    final var order3 = OrderBuilder.create().withId(2L).build();

    return List.of(
        OrderDetailBuilder.create()
            .withOrder(order1)
            .withProduct(productList.get(0))
            .withUnitPrice(productList.get(0).getPrice())
            .withQuantity(1)
            .withDiscount(0.00)
            .withStatus(Status.ACTIVE)
            .build(),
        OrderDetailBuilder.create()
            .withOrder(order1)
            .withProduct(productList.get(1))
            .withUnitPrice(productList.get(1).getPrice())
            .withQuantity(3)
            .withDiscount(0.00)
            .withStatus(Status.ACTIVE)
            .build(),
        OrderDetailBuilder.create()
            .withOrder(order2)
            .withProduct(productList.get(1))
            .withUnitPrice(productList.get(1).getPrice())
            .withQuantity(2)
            .withDiscount(0.02)
            .withStatus(Status.ACTIVE)
            .build(),
        OrderDetailBuilder.create()
            .withOrder(order2)
            .withProduct(productList.get(2))
            .withUnitPrice(productList.get(2).getPrice())
            .withQuantity(1)
            .withDiscount(0.00)
            .withStatus(Status.ACTIVE)
            .build(),
        OrderDetailBuilder.create()
            .withOrder(order3)
            .withProduct(productList.get(2))
            .withUnitPrice(productList.get(2).getPrice())
            .withQuantity(1)
            .withDiscount(0.02)
            .withStatus(Status.ACTIVE)
            .build());
  }

  @Override
  public void save(List<OrderDetail> orderDetailsEntities) {
    orderDetailsEntities.forEach(orderDetailRepository::insert);
  }
}
