package com.ot.restaurant.seeder;

import com.ot.restaurant.builders.OrderBuilder;
import com.ot.restaurant.builders.OrderDetailBuilder;
import com.ot.restaurant.constants.Status;
import com.ot.restaurant.entities.Customer;
import com.ot.restaurant.entities.Order;
import com.ot.restaurant.entities.OrderDetail;
import com.ot.restaurant.entities.Product;
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
    final var newCustomer1 = ioc.resolve("Loki1");
    final var newCustomer2 = ioc.resolve("Loki2");
    final var newCustomer3 = ioc.resolve("Loki3");

    final var CheeseburgerProduct = ioc.resolve("Cheeseburger");
    final var ChickenburgerProduct = ioc.resolve("Chickenburger");
    final var VeggieburgerProduct = ioc.resolve("Veggieburger");

    final var newDetail1 =
        List.of(
            OrderDetailBuilder.create()
                .withProduct((Product) CheeseburgerProduct)
                .withQuantity(1)
                .withUnitPrice(13.00)
                .withDiscount(0.00)
                .withStatus(Status.ACTIVE)
                .build(),
            OrderDetailBuilder.create()
                .withProduct((Product) ChickenburgerProduct)
                .withQuantity(3)
                .withUnitPrice(14.00)
                .withDiscount(0.00)
                .withStatus(Status.ACTIVE)
                .build());

    final var newDetail2 =
        List.of(
            OrderDetailBuilder.create()
                .withProduct((Product) VeggieburgerProduct)
                .withQuantity(2)
                .withUnitPrice(18.00)
                .withDiscount(0.02)
                .withStatus(Status.ACTIVE)
                .build(),
            OrderDetailBuilder.create()
                .withProduct((Product) CheeseburgerProduct)
                .withQuantity(1)
                .withUnitPrice(14.00)
                .withDiscount(0.00)
                .withStatus(Status.ACTIVE)
                .build());

    final var newDetail3 =
        List.of(
            OrderDetailBuilder.create()
                .withProduct((Product) VeggieburgerProduct)
                .withQuantity(1)
                .withUnitPrice(18.00)
                .withDiscount(0.02)
                .withStatus(Status.ACTIVE)
                .build());

    return List.of(
        OrderBuilder.create()
            .withCustomerInfo((Customer) newCustomer1)
            .withOrderDetail(newDetail1)
            .withTotalAmount(calculateTotalAmount(newDetail1))
            .withStatus(Status.ACTIVE)
            .build(),
        OrderBuilder.create()
            .withCustomerInfo((Customer) newCustomer2)
            .withOrderDetail(newDetail2)
            .withTotalAmount(calculateTotalAmount(newDetail2))
            .withStatus(Status.ACTIVE)
            .build(),
        OrderBuilder.create()
            .withCustomerInfo((Customer) newCustomer3)
            .withOrderDetail(newDetail3)
            .withTotalAmount(calculateTotalAmount(newDetail3))
            .withStatus(Status.ACTIVE)
            .build());
  }

  private double calculateTotalAmount(List<OrderDetail> orderDetailList) {
    double total = 0.0;

    if (orderDetailList != null) {

      for (OrderDetail orderDetail : orderDetailList) {
        total =
            orderDetail.getQuantity()
                * orderDetail.getUnitPrice()
                * (1 - orderDetail.getDiscount());
      }
    }

    return total;
  }

  @Override
  public void save(List<Order> orderEntities) {
    orderEntities.forEach(orderRepository::insert);
  }
}
