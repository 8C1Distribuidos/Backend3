package com.leckereweine.be3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class CompraParaBD {
    private int id;
    private int idUser;
    private LocalDateTime dateTime;
    private double totalPrice;
    private List<Producto> purchaseList;
    private String address;
    private Ciudad city;
    private String zipCode;

    public CompraParaBD(int id, LocalDateTime dateTime, double totalPrice, List<Producto> purchaseList) {
        this.id = id;
        this.dateTime = dateTime;
        this.totalPrice = totalPrice;
        this.purchaseList = purchaseList;
    }

    public CompraParaBD() {
    }

    public int getUsuario() {
        return id;
    }

    public void setUsuario(int usuario) {
        this.id = usuario;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Producto> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Producto> purchaseList) {
        this.purchaseList = purchaseList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Ciudad getCity() {
        return city;
    }

    public void setCity(Ciudad city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
