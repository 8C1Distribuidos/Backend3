package com.leckereweine.be3;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class CompraService {

    List<Producto> listaProductos;
    double costoFinal;
    RestTemplate restTemplate;
    private static final String BD_URL = "http://localhost:9081/";

    public Compra getCompra() {
        /*List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(0, 3, "Baileys", 200.0));
        productos.add(new Producto(1, 2, "JoseCuervo", 250.0));
        productos.add(new Producto(2, 1, "Changyu", 500));
        productos.add(new Producto(3, 6, "Chandon", 450));
        productos.add(new Producto(4, 1, "Barefoot", 100));*/

        LocalDate date = LocalDate.of(2021, 9, 11);
        Compra compra = new Compra(listaProductos, 0, date, costoFinal, 0, 0, date);

        return compra;
    }

    public List<Producto> getProducts(List<Producto> productos) {


        /*LocalDate date = LocalDate.of(2021, 9, 11);

        Compra compra = new Compra(productos, 0, "Info", date);*/

        listaProductos = productos;
        for (Producto p:productos) {
            costoFinal += p.getPrecio();
        }
        return productos;
    }

    public Compra setCompra(Compra compra){
        return CompraExternService.postCompra(compra);
    }

    public List<Compra> historialCompras(int id_usuario) {
        List<Compra> compras = CompraExternService.getHistorialCompras(id_usuario);


        List<Producto> productos = new ArrayList<>();
        for (var compra: compras) {
            for(var productoEnCompra: compra.getListaProductos()){
                productos.add(productoEnCompra);
            }
        }
        productos = CompraExternService.getInfoProductos(productos);

        for(var compra: compras){
            List<Producto> productosCompraActual = compra.getListaProductos();
            for(var producto: productos){
                for(var productoDeCompra: productosCompraActual){
                    if(producto.getId_producto() == productoDeCompra.getId_producto()){
                        productoDeCompra = producto;
                    }
                }
            }
            compra.setListaProductos(productosCompraActual);
        }

        return compras;

        //return CompraExternService.getHistorialCompras(id_usuario);
    }

    /*public void getProductss(List<Producto> productos) {


        LocalDate date = LocalDate.of(2021, 9, 11);

        Compra compra = new Compra(productos, 0, "Info", date);


    }*/
}
