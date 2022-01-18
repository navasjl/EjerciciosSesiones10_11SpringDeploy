package com.example.EjerciciosSesiones10y11SpringDeploy.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${app.state}")
    String state;

    @Value("${app.ruta}")
    String ruta;

    //si usas get en Postman or localhost:port/hola en navegador, imprime "Hola chaval!!!"
    //Aqui le añadimos propiedades para desarrollo y para tests y usamos esas propiedades en el controlador
    @GetMapping("/hola")
    public String saludar(){

        System.out.println("Ahora mismo "+state+". La ruta sigue siendo: "+ruta);

        return "Hola chaval!!!";
    }
}
