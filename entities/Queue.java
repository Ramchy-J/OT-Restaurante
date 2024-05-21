package entities;

import java.util.List;

public class Queue extends Base {

    //Attributes

    private List<Order> orders;
    private Integer currentOrderIndex;

    //Constructors

    public Queue() {
    }

    public Queue(List<Order> orders, Integer currentOrderIndex) {
        this.orders = orders;
        this.currentOrderIndex = currentOrderIndex;
    }

    //Methods

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Integer getCurrentOrderIndex() {
        return currentOrderIndex;
    }

    public void setCurrentOrderIndex(Integer currentOrderIndex) {
        this.currentOrderIndex = currentOrderIndex;
    }

    public void enqueueOrder(Order order){
        orders.add(order);
    }

    public Order dequeueOrder(){
        if(!orders.isEmpty()){
            return orders.removeFirst();
        }
        else {
            return null;
        }
    }
}

