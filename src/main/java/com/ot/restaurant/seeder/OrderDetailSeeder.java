package com.ot.restaurant.seeder;

import com.ot.restaurant.builders.OrderDetailBuilder;
import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.Order;
import com.ot.restaurant.entities.OrderDetail;
import com.ot.restaurant.entities.Product;
import com.ot.restaurant.ioc.IoCContainer;
import com.ot.restaurant.repositories.OrderDetailRepository;
import java.util.List;

public class OrderDetailSeeder extends AbstractSeeder<OrderDetail> {

  private final OrderDetailRepository orderDetailRepository;
  private final IoCContainer ioc = IoCContainer.getInstance();

  public OrderDetailSeeder(OrderDetailRepository orderDetailRepository) {
    this.orderDetailRepository = orderDetailRepository;
  }

  @Override
  public List<OrderDetail> load() throws Exception {
    final var newOrder1 = ((Order) ioc.resolve("Loki"));
    final var newOrder2 = ((Order) ioc.resolve("Loki2"));
    final var newOrder3 = ((Order) ioc.resolve("Loki3"));

    final var CheeseburgerProduct = ioc.resolve("Cheeseburger");
    final var ChickenburgerProduct = ioc.resolve("Chickenburger");
    final var VeggieburgerProduct = ioc.resolve("Veggieburger");

    return List.of(
        OrderDetailBuilder.create()
            .withOrder(newOrder1)
            .withProduct((Product) CheeseburgerProduct)
            .withQuantity(1)
            .withUnitPrice(13.00)
            .withDiscount(0.00)
            .withStatus(Status.ACTIVE)
            .build(),
        OrderDetailBuilder.create()
            .withOrder(newOrder1)
            .withProduct((Product) ChickenburgerProduct)
            .withQuantity(3)
            .withUnitPrice(14.00)
            .withDiscount(0.00)
            .withStatus(Status.ACTIVE)
            .build(),
        OrderDetailBuilder.create()
            .withOrder(newOrder2)
            .withProduct((Product) VeggieburgerProduct)
            .withQuantity(2)
            .withUnitPrice(18.00)
            .withDiscount(0.02)
            .withStatus(Status.ACTIVE)
            .build(),
        OrderDetailBuilder.create()
            .withOrder(newOrder2)
            .withProduct((Product) CheeseburgerProduct)
            .withQuantity(1)
            .withUnitPrice(14.00)
            .withDiscount(0.00)
            .withStatus(Status.ACTIVE)
            .build(),
        OrderDetailBuilder.create()
            .withOrder(newOrder3)
            .withProduct((Product) VeggieburgerProduct)
            .withQuantity(1)
            .withUnitPrice(18.00)
            .withDiscount(0.02)
            .withStatus(Status.ACTIVE)
            .build());
  }

  @Override
  public void save(List<OrderDetail> orderDetailsEntities) {
    orderDetailsEntities.forEach(orderDetailRepository::insert);
  }
}
