package entities;

import constants.Status;

import java.time.Instant;
import java.util.List;

public class Product extends Base{

    //Attributes

    private String name;
    private Double price;
    private String category;
    private List <Ingredients> ingredients;

    //Constructors

    public Product(){

    }

    public Product(Long id, Instant createdDate, Instant updatedDate, Long createdBy, Long updatedBy, Status status, String name, Double price, String category, List<Ingredients> ingredients) {
        super(id, createdDate, updatedDate, createdBy, updatedBy, status);
        this.name = name;
        this.price = price;
        this.category = category;
        this.ingredients = ingredients;
    }

    //Methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
