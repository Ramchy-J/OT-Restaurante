package entities;

import java.util.Date;
import java.util.List;

public class Product extends Base{

    //Attributes

    private Double price;
    private String category;
    private List <Ingredients> ingredients;

    //Constructors

    public Product(){

    }

    public Product(Integer entityId, String entityName, Date createdDate, Date modifiedDate, Double price, String category, List<Ingredients> ingredients) {
        super(entityId, entityName, createdDate, modifiedDate);
        this.price = price;
        this.category = category;
        this.ingredients = ingredients;
    }

    //Methods

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }
}
