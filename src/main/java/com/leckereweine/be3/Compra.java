package com.leckereweine.be3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Compra {
    private List<Producto> listaProductos;
    private int id_usuario;
    private String info_usuario;
    private LocalDate fecha;

    /*public int getId_producto() {
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
    }*/

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /*public Compra(int id_producto, int cantidad, int id_usuario, String info_usuario, LocalDate fecha) {
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.id_usuario = id_usuario;
        this.info_usuario = info_usuario;
        this.fecha = fecha;
    }*/

    public Compra(List<Producto> productos, int id_usuario, String info_usuario, LocalDate fecha) {
        this.listaProductos = productos;
        this.id_usuario = id_usuario;
        this.info_usuario = info_usuario;
        this.fecha = fecha;
    }
}
