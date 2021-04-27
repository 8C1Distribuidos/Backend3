package com.leckereweine.be3;


public class Producto {
    private int id;
    private int stack;
    private String name;
    private double price;
    private String imageLink;
    private Category category;


    public Producto(int id, int stack, String name, double price, String imageLink, Category category) {
        this.id = id;
        this.stack = stack;
        this.name = name;
        this.price = price;
        this.imageLink = imageLink;
        this.category = category;
    }

    public Producto(){

    }

    public Producto(int id, int stack) {
        this.id = id;
        this.stack = stack;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStack() {
        return stack;
    }

    public void setStack(int stack) {
        this.stack = stack;
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
}
