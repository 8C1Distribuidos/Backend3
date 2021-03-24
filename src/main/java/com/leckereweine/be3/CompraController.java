package com.leckereweine.be3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/compra")
@RestController
public class CompraController {

    @Autowired
    private CompraService compraService;

    /*@GetMapping("/compra")
    public Compra compra(

            @RequestParam List<Producto> productos,

            @RequestParam int id_usuario,
            @RequestParam (value = "info", defaultValue = "No info") String info_usuario,
            @RequestParam LocalDate fecha

            ){
        return new Compra(productos, id_usuario, info_usuario, fecha);
    }*/


    @GetMapping("/enviar")
    public ResponseEntity<Compra> compra(){
        return ResponseEntity.ok(compraService.getCompra());
    }

    @PostMapping("/recibir")
    public ResponseEntity<List<Producto>> recibirProducto(@RequestBody List<Producto> productos){
        return ResponseEntity.ok(compraService.getProducts(productos));
    }
}
