package entities;

import constants.Status;

import java.time.Instant;
import java.util.List;

public class Order extends Base {
    //Attributes

    private Customer customerInfo;
    private List<OrderDetail> orderDetails;
    private Double totalAmount;

    //Constructors

    public Order() {
    }

    public Order(Long id, Instant createdDate, Instant updatedDate, Long createdBy, Long updatedBy, Status status, Customer customerInfo, List<OrderDetail> orderDetails, Double totalAmount) {
        super(id, createdDate, updatedDate, createdBy, updatedBy, status);
        this.customerInfo = customerInfo;
        this.orderDetails = orderDetails;
        this.totalAmount = totalAmount;
    }

    //Methods

    public Customer getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(Customer customerInfo) {
        this.customerInfo = customerInfo;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}

