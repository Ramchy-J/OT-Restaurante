package entities;

import constants.Status;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class Order extends Base {
    //Attributes

    private Customer customerInfo;
    private List<Product> items;
    private Double totalAmount;

    //Constructors

    public Order() {
    }

    public Order(Long id, Instant createdDate, Instant updatedDate, Long createdBy, Long updatedBy, Status status, Customer customerInfo, List<Product> items, Double totalAmount, Date orderDate) {
        super(id, createdDate, updatedDate, createdBy, updatedBy, status);
        this.customerInfo = customerInfo;
        this.items = items;
        this.totalAmount = totalAmount;
    }

    //Methods

    public Customer getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(Customer customerInfo) {
        this.customerInfo = customerInfo;
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}

