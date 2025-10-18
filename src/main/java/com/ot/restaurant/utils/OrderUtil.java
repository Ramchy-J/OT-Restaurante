package com.ot.restaurant.utils;

import com.ot.restaurant.entities.OrderDetail;
import java.util.List;

public class OrderUtil {

  public static Double calculateOrderDetailSubtotal(OrderDetail orderDetail) {
    return orderDetail.getQuantity() * orderDetail.getUnitPrice();
  }

  public static Double calculateOrderDetailTotal(OrderDetail orderDetail) {
    return calculateOrderDetailSubtotal(orderDetail) * (1.00 - orderDetail.getDiscount());
  }

  public static Double calculateOrderTotalAmount(List<OrderDetail> orderDetailList) {
    return orderDetailList.stream()
        .map(OrderUtil::calculateOrderDetailTotal)
        .reduce(0.00, Double::sum);
  }
}
