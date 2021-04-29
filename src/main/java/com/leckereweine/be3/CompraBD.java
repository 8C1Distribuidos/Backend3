package com.leckereweine.be3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class CompraBD {
    private List<ProductoBD> purchaseList;

    private LocalDateTime dateTime;
    private double totalPrice;

    public CompraBD(){

    }

    public List<ProductoBD> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<ProductoBD> purchaseList) {
        this.purchaseList = purchaseList;
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
}
