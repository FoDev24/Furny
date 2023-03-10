package com.example.furniture.models;

public class Products {
    private String name;
    private String price;
    private String category;
    private String image;
    private String pid;
    private String model;
    private String description;
    private String quantity;

    public Products() {
    }

    public Products(String name, String price, String category, String image, String pid, String model, String description) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.image = image;
        this.pid = pid;
        this.model=model;
        this.description = description;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getModel() { return model; }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}


