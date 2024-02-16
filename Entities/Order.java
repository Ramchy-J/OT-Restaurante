package Entities;

import java.util.Date;
import java.util.List;

public class Order {
    //Attributes
    private Integer orderId;
    private String customerName;
    private List <Product> items;
    private Double totalAmount;
    private Date orderDate;

    //Constructors

    public Order() {
    }

    public Order(Integer orderId, String customerName, List<Product> items, Double totalAmount, Date orderDate) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.items = items;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
    }


    //Methods

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    public void addItems(Product item){
        items.add(item);
        totalAmount += item.getPrice();
    }

    public void removeItems(Product item){
        items.remove(item);
        totalAmount -= item.getPrice();
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
