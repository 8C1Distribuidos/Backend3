package com.leckereweine.be3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompraController {

    @GetMapping("/compra")
    public Compra compra(

            @RequestParam int id_producto,
            @RequestParam int cantidad,
            @RequestParam int id_usuario,
            @RequestParam (value = "info", defaultValue = "No info") String info_usuario

    ){
        return new Compra(id_producto, cantidad, id_usuario, info_usuario);
    }
}
