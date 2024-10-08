package com.restaurante.entities;

import constants.Status;
import entities.Base;
import entities.Order;
import entities.Product;
import java.time.Instant;

public class OrderDetail extends Base {

    // Attributes
    private entities.Order order;
    private entities.Product product;
    private Integer quantity;
    private Double unitPrice;
    private Double discount;

    // Constructor

    public OrderDetail() {}

    public OrderDetail(
            final Long id,
            final Instant createdDate,
            final Instant updatedDate,
            final Long createdBy,
            final Long updatedBy,
            final Status status,
            final entities.Order order,
            final entities.Product product,
            final Integer quantity,
            final Double unitPrice,
            final Double discount) {
        super(id, createdDate, updatedDate, createdBy, updatedBy, status);
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discount = discount;
    }

    // Methods

    public entities.Order getOrder() {
        return order;
    }

    public void setOrder(final Order order) {
        this.order = order;
    }

    public entities.Product getProduct() {
        return product;
    }

    public void setProduct(final Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(final Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(final Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(final Double discount) {
        this.discount = discount;
    }
}
