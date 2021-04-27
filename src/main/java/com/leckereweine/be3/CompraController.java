package com.leckereweine.be3;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/compra")
@RestController
public class CompraController {

    @Autowired
    private CompraService compraService;


    @GetMapping("/")
    @CrossOrigin()
    public ResponseEntity<Compra> compra(){
        return ResponseEntity.ok(compraService.getCompra());
    }

    @PostMapping("/recibir")
    @CrossOrigin()
    public ResponseEntity<Compra> recibirCompra(@RequestBody Compra compra){
        compra.setFecha(LocalDate.now());
        Compra comprita = compraService.setCompra(compra);
        if(comprita != null){
            return ResponseEntity.ok(comprita);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/historialCompras")
    @CrossOrigin()
    public ResponseEntity<List<Compra>> historialCompras(@RequestBody Usuario usuario){

        return ResponseEntity.ok(compraService.historialCompras(usuario.getId_usuario()));

    }

    @GetMapping("/ciudad")
    @CrossOrigin()
    public ResponseEntity<List<Ciudad>> getCiudades(){
        return ResponseEntity.ok(compraService.getCiudades());
    }





}
