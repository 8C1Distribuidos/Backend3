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
    CompraRepository compraRepository;

    @GetMapping("/")
    public ResponseEntity<Compra> compra(){
        return ResponseEntity.ok(compraService.getCompra());
    }

    @PostMapping("/recibir")
    public ResponseEntity<Compra> recibirCompra(@RequestBody Compra compra){
        return ResponseEntity.ok(compraService.setCompra(compra));
    }

    @PostMapping("/historialCompras")
    public ResponseEntity<List<Compra>> historialCompras(@PathVariable("id") int id_usuario){
        return ResponseEntity.ok(compraService.historialCompras(id_usuario));
    }






}
