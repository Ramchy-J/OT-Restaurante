package entities;

import constants.Status;

import java.time.Instant;

public class OrderDetail extends Base {

    //Attributes
    private Order order;
    private Product product;
    private Integer quantity;
    private Double unitPrice;
    private Double discount;

    //Constructor


    public OrderDetail() {
    }

    public OrderDetail(Long id, Instant createdDate, Instant updatedDate, Long createdBy, Long updatedBy, Status status, Order order, Product product, Integer quantity, Double unitPrice, Double discount) {
        super(id, createdDate, updatedDate, createdBy, updatedBy, status);
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discount = discount;
    }

    //Methods


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
