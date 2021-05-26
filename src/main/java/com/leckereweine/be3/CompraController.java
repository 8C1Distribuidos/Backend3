package com.leckereweine.be3;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/compra")
@RestController
public class CompraController {

    @Autowired
    private CompraService compraService;


    @GetMapping("/")
    @CrossOrigin()
    public ResponseEntity<List<Integer>> compra(){
        List<Integer> ints = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            Integer x = i;
            ints.add(x);
        }
        return ResponseEntity.ok(ints);
    }

    @PostMapping("/recibir")
    @CrossOrigin()
    public ResponseEntity<CompraParaBD> recibirCompra(@RequestBody Compra compra){
        compra.setFecha(LocalDateTime.now());


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String [] fechaRecibida = compra.getStringFecha().split("/");
        String fecha = "01/" + fechaRecibida[0] + "/20" + fechaRecibida[1];
        compra.setFechaTarjeta(LocalDate.parse(fecha, formatter));



        return compraService.setCompra(compra);

        //return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/historialCompras")
    @CrossOrigin()
    public ResponseEntity<List<CompraBD>> historialCompras(@RequestParam int id_usuario){

        return ResponseEntity.ok(compraService.historialCompras(id_usuario));

    }

    @GetMapping("/ciudad")
    @CrossOrigin()
    public ResponseEntity<List<Ciudad>> getCiudades(){
        return ResponseEntity.ok(compraService.getCiudades());
    }

    @GetMapping("/actividades")
    @CrossOrigin()
    public ResponseEntity<List<String>> getActivities(){
        return ResponseEntity.ok(compraService.getActivities());
    }



}
