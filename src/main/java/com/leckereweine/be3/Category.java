package com.leckereweine.be3;

public class Category {
    private int id;
    private String name;
    Catalog catalog;

    public Category(int id, String name, Catalog catalog) {
        this.id = id;
        this.name = name;
        this.catalog = catalog;
    }

    public Category(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
