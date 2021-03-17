package com.leckereweine.be3;

public class Compra {
    private int id_producto;
    private int cantidad;
    private int id_usuario;
    private String info_usuario;

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

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getInfo_usuario() {
        return info_usuario;
    }

    public void setInfo_usuario(String info_usuario) {
        this.info_usuario = info_usuario;
    }

    public Compra(int id_producto, int cantidad, int id_usuario, String info_usuario) {
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.id_usuario = id_usuario;
        this.info_usuario = info_usuario;
    }
}
