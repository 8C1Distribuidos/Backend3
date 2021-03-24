package com.leckereweine.be3;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class CompraService {
    public Compra getCompra() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(0, 3, "Baileys", 200.0));
        productos.add(new Producto(1, 2, "JoseCuervo", 250.0));
        productos.add(new Producto(2, 1, "Changyu", 500));
        productos.add(new Producto(3, 6, "Chandon", 450));
        productos.add(new Producto(4, 1, "Barefoot", 100));

        LocalDate date = LocalDate.of(2021, 9, 11);

        Compra compra = new Compra(productos, 0, "Info", date);

        return compra;
    }

    public List<Producto> getProducts(List<Producto> productos) {


        LocalDate date = LocalDate.of(2021, 9, 11);

        Compra compra = new Compra(productos, 0, "Info", date);

        return productos;
    }

    /*public void getProductss(List<Producto> productos) {


        LocalDate date = LocalDate.of(2021, 9, 11);

        Compra compra = new Compra(productos, 0, "Info", date);


    }*/
}
