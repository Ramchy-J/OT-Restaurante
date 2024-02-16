package entities;

import java.util.List;

public class Product {

    //Attributes

    private Integer productId;
    private String name;
    private Double price;
    private String category;
    private List <Ingredients> ingredients;

    //Constructors

    public Product(){

    }
    public Product(Integer productId, String name, Double price, String category, List<Ingredients> ingredients) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.ingredients = ingredients;
    }

    //Methods

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

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
