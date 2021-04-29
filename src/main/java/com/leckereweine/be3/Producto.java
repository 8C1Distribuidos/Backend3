package com.leckereweine.be3;


public class Producto {
    private int id;
    private int stock;
    private String name;
    private double price;
    private String imageLink;
    private Category category;
    private int amount;

    public Producto(int id, int stock, String name, double price, String imageLink, Category category, int amount) {
        this.id = id;
        this.stock = stock;
        this.name = name;
        this.price = price;
        this.imageLink = imageLink;
        this.category = category;
        this.amount = amount;
    }

    public Producto(int id, int stock, String name, double price, String imageLink, Category category) {
        this.id = id;
        this.stock = stock;
        this.name = name;
        this.price = price;
        this.imageLink = imageLink;
        this.category = category;
    }

    public Producto(){

    }

    public Producto(int id, int stock) {
        this.id = id;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
