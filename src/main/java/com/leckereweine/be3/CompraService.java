package com.leckereweine.be3;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompraService {

    List<Producto> listaProductos, aux;
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

    public ResponseEntity<CompraParaBD> setCompra(Compra compra){
        Usuario user = CompraExternService.getUser(compra.getId_usuario());
        if(user != null){
            List<Producto> productos;
            aux = new ArrayList<>();
            List<Integer> idProductos = new ArrayList<>();

            productos = compra.getListaProductos();
            for (Producto prod:productos) {
                idProductos.add(prod.getId());
            }

            /*Thread hilito = new Thread(){
                public void run(){
                    aux = CompraExternService.getInfoProductos(idProductos);
                }
            };
            hilito.start();
            try {
                hilito.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

            aux = CompraExternService.getInfoProductos(idProductos);

            for(int i = 0; i<aux.size(); i++){
                aux.get(i).setAmount(productos.get(i).getAmount());
            }

            if(CompraExternService.enviarLista(aux) == 1){
                return ResponseEntity.status(HttpStatus.CONFLICT).body(null); //409
            }

            if(aux.size() == productos.size()){
                int enteroAux = CompraExternService.checkCompra(compra);
                if(enteroAux == 0) {
                    CompraParaBD comprita = new CompraParaBD(0, compra.getFecha(), compra.getPrecioFinal(), compra.getListaProductos());
                    comprita.setAddress(compra.getDireccion());
                    comprita.setCity(compra.getCiudad());
                    comprita.setIdUser(compra.getId_usuario());
                    comprita.setZipCode(compra.getCp());

                    /*for(Producto prod : aux){
                        if(prod.getStock() <= 0) return ResponseEntity.status(HttpStatus.CONFLICT).body(null); //409
                    }*/

                    return ResponseEntity.ok(CompraExternService.postCompra(comprita));
                }else if(enteroAux == 1){
                    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null); //422
                }else if(enteroAux == 2){
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); //404
                }else if(enteroAux == 3){
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); //400
                }else if(enteroAux == 5){
                    return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null); //503
                }

            }
        }
        return null;

    }

    public List<CompraBD> historialCompras(int id_usuario) {
        Usuario user = CompraExternService.getUser(id_usuario);

        if(user != null){
            List<CompraBD> comprasBD = CompraExternService.getHistorialCompras(user);
            //List<Compra> compras = CompraExternService.getHistorialCompras(user);
            if(comprasBD != null){
                for(var compraBD: comprasBD){

                    List<Integer> idProductos = new ArrayList<>();
                    for (ProductoBD prod:compraBD.getPurchaseList()) {
                        idProductos.add(prod.getId());
                    }

                    List<Producto> prods = CompraExternService.getInfoProductos(idProductos);


                    for(int i = 0; i < prods.size(); i++){
                        compraBD.getPurchaseList().get(i).setName( prods.get(i).getName() );
                        compraBD.getPurchaseList().get(i).setImageLink( prods.get(i).getImageLink() );
                        compraBD.getPurchaseList().get(i).setCategory( prods.get(i).getCategory() );
                    }

                    //compraBD.setPurchaseList(CompraExternService.getInfoProductos(idProductos));



                }
            }

            return comprasBD;
        }

        return null;

    }

    public List<Ciudad> getCiudades(){
        List<Ciudad> ciudades = CompraExternService.getCiudades();

        return ciudades;
    }
}
