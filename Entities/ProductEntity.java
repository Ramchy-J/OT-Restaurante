package Entities;

import java.util.List;

public class ProductEntity {
    //Attributes
    private int productId;
    private String name;
    private double price;
    private String category;
    private List <String> ingredients;


    //Constructors
    public ProductEntity(){

    }
    public ProductEntity(int productId, String name, double price, String category, List<String> ingredients) {
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

    public void setProductId(int productId) {
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

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
