package com.leckereweine.be3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Compra {
    private List<Producto> listaProductos;
    private int id_usuario;
    private LocalDate fecha;
    private double precioFinal;
    private String numeroTarjeta;
    private String cvvTarjeta;
    private LocalDate fechaTarjeta;
    private String direccion;
    private String cp;
    private Ciudad ciudad;

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

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getCvvTarjeta() {
        return cvvTarjeta;
    }

    public void setCvvTarjeta(String cvvTarjeta) {
        this.cvvTarjeta = cvvTarjeta;
    }

    public LocalDate getFechaTarjeta() {
        return fechaTarjeta;
    }

    public void setFechaTarjeta(LocalDate fechaTarjeta) {
        this.fechaTarjeta = fechaTarjeta;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Compra() {

    }

    public Compra(List<Producto> listaProductos, int id_usuario, LocalDate fecha, double precioFinal, String numeroTarjeta, String cvvTarjeta, LocalDate fechaTarjeta, String direccion, String cp, Ciudad ciudad) {
        this.listaProductos = listaProductos;
        this.id_usuario = id_usuario;
        this.fecha = fecha;
        this.precioFinal = precioFinal;
        this.numeroTarjeta = numeroTarjeta;
        this.cvvTarjeta = cvvTarjeta;
        this.fechaTarjeta = fechaTarjeta;
        this.direccion = direccion;
        this.cp = cp;
        this.ciudad = ciudad;
    }

    public Compra(List<Producto> listaProductos, int id_usuario, LocalDate fecha, double precioFinal, String numeroTarjeta, String cvvTarjeta, LocalDate fechaTarjeta) {
        this.listaProductos = listaProductos;
        this.id_usuario = id_usuario;
        this.fecha = fecha;
        this.precioFinal = precioFinal;
        this.numeroTarjeta = numeroTarjeta;
        this.cvvTarjeta = cvvTarjeta;
        this.fechaTarjeta = fechaTarjeta;
    }

    public Compra(List<Producto> listaProductos, int id_usuario, LocalDate fecha, double precioFinal) {
        this.listaProductos = listaProductos;
        this.id_usuario = id_usuario;
        this.fecha = fecha;
        this.precioFinal = precioFinal;
    }
}
