package entities;

import java.util.Date;
import java.util.List;

public class Order extends Base {
    //Attributes

    private List<Product> items;
    private Double totalAmount;

    //Constructors

    public Order() {
    }

    public Order(Integer entityId, String entityName, Date createdDate, Date modifiedDate, List<Product> items, Double totalAmount) {
        super(entityId, entityName, createdDate, modifiedDate);
        this.items = items;
        this.totalAmount = totalAmount;
    }

    //Methods


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

    public void addItems(Product item){
        items.add(item);
        totalAmount += item.getPrice();
    }

}
