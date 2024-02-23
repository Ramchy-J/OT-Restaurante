package entities;

import java.util.List;

public class Product {

    //Attributes

    private Integer productId;
    private String name;
    private Double price;
    private String category;
    private List <Ingredient> ingredients;

    //Constructors

    public Product(){

    }
    public Product(Integer productId, String name, Double price, String category, List<Ingredient> ingredients) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.ingredients = ingredients;
    }

    //Methods

    public int getProductId() {
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

    public double getPrice() {
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
