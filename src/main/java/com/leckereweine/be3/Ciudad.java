package com.leckereweine.be3;

public class Ciudad {
    private int id;
    private String name;

    public Ciudad(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Ciudad(){

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
}
