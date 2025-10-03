package com.ot.restaurant.seeder;

import com.ot.restaurant.builders.OrderDetailBuilder;
import com.ot.restaurant.constants.Status;
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
    final var productCheeseburger = ioc.resolve("Cheeseburger");
    final var productChickenburger = ioc.resolve("Chickenburger");
    final var productVeggieburger = ioc.resolve("Veggieburger");

    return List.of(
        OrderDetailBuilder.create()
            .withProduct((Product) productCheeseburger)
            .withQuantity(2)
            .withUnitPrice(15.00)
            .withDiscount(0.00)
            .withStatus(Status.ACTIVE)
            .build(),
        OrderDetailBuilder.create()
            .withProduct((Product) productChickenburger)
            .withQuantity(1)
            .withUnitPrice(18.00)
            .withDiscount(0.00)
            .withStatus(Status.ACTIVE)
            .build());
  }

  @Override
  public void save(List<OrderDetail> orderDetailsEntities) {
    orderDetailsEntities.forEach(orderDetailRepository::insert);
  }
}
