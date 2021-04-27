package com.leckereweine.be3;

import java.time.LocalDate;
import java.util.List;

public class CompraParaBD {
    private int id;
    private LocalDate fecha;
    private double precioFinal;
    private List<Producto> listaProductos;

    public CompraParaBD(int id, LocalDate fecha, double precioFinal, List<Producto> listaProductos) {
        this.id = id;
        this.fecha = fecha;
        this.precioFinal = precioFinal;
        this.listaProductos = listaProductos;
    }

    public CompraParaBD() {
    }

    public int getUsuario() {
        return id;
    }

    public void setUsuario(int usuario) {
        this.id = usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
