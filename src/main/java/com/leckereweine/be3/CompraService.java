package com.leckereweine.be3;

import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompraService {

    List<Producto> listaProductos;
    double costoFinal;


    public Compra getCompra() {
        /*List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(0, 3, "Baileys", 200.0));
        productos.add(new Producto(1, 2, "JoseCuervo", 250.0));
        productos.add(new Producto(2, 1, "Changyu", 500));
        productos.add(new Producto(3, 6, "Chandon", 450));
        productos.add(new Producto(4, 1, "Barefoot", 100));*/

        LocalDate date = LocalDate.of(2021, 9, 11);
        //Compra compra = new Compra(listaProductos, 0, date, costoFinal, 0, 0, date);

        return null;
    }

    public List<Producto> getProducts(List<Producto> productos) {


        /*LocalDate date = LocalDate.of(2021, 9, 11);

        Compra compra = new Compra(productos, 0, "Info", date);*/

        listaProductos = productos;
        for (Producto p:productos) {
            costoFinal += p.getPrice();
        }
        return productos;
    }

    public Compra setCompra(Compra compra){
        Usuario user = CompraExternService.getUser(compra.getId_usuario());
        if(user != null){
            List<Producto> productos;
            List<Producto> aux = new ArrayList<>();
            List<Integer> idProductos = new ArrayList<>();

            productos = compra.getListaProductos();
            for (Producto prod:productos) {
                idProductos.add(prod.getId());
            }
            aux = CompraExternService.getInfoProductos(idProductos);
            if(aux.size() == productos.size()){
                if(CompraExternService.checkCompra(compra)) {
                    CompraParaBD comprita = new CompraParaBD(compra.getId_usuario(), compra.getFecha(), compra.getPrecioFinal(), compra.getListaProductos());
                    return CompraExternService.postCompra(comprita);
                }

            }
        }
        return null;

    }

    public List<Compra> historialCompras(int id_usuario) {
        Usuario user = CompraExternService.getUser(id_usuario);

        List<Compra> compras = CompraExternService.getHistorialCompras(user);

        for(var compra: compras){

            List<Integer> idProductos = new ArrayList<>();
            for (Producto prod:compra.getListaProductos()) {
                idProductos.add(prod.getId());
            }
            compra.setListaProductos(CompraExternService.getInfoProductos(idProductos));


            List<Producto> productosAux = new ArrayList<>();
            for(var prod: compra.getListaProductos()){
                Producto aux = new Producto();

                Category cat = new Category();
                cat.setName(prod.getCategory().getName());

                aux.setName(prod.getName());
                aux.setImageLink(prod.getImageLink());
                aux.setCategory(cat);

                productosAux.add(aux);
            }

            compra.setListaProductos(productosAux);
        }

        /*List<Producto> productos = new ArrayList<>();
        for (var compra: compras) {
            for(var productoEnCompra: compra.getListaProductos()){
                productos.add(productoEnCompra);
            }
        }

        List<Integer> idProductos = new ArrayList<>();
        for (Producto prod:productos) {
            idProductos.add(prod.getId_producto());
        }
        productos = CompraExternService.getInfoProductos(idProductos);

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
        }*/

        return compras;


    }

    public List<Ciudad> getCiudades(){
        List<Ciudad> ciudades = CompraExternService.getCiudades();

        return ciudades;
    }
}
