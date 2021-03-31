package com.leckereweine.be3;


public class Producto {
    private int id_producto;
    private int cantidad;
    private String nombre;
    private double precio;
    private String imageLink;
    private Categoria categoria;

    public Producto(int id_producto, int cantidad, String nombre, double precio, String imageLink, Categoria categoria) {
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.precio = precio;
        this.imageLink = imageLink;
        this.categoria = categoria;
    }

    public Producto(){

    }

    public Producto(int id_producto, int cantidad) {
        this.id_producto = id_producto;
        this.cantidad = cantidad;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
