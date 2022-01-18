package com.example.EjerciciosSesiones10y11SpringDeploy.controllers;

import com.example.EjerciciosSesiones10y11SpringDeploy.entities.Laptop;
import com.example.EjerciciosSesiones10y11SpringDeploy.repository.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private LaptopRepository laptopRepository;

    private final Logger log= LoggerFactory.getLogger(LaptopController.class);

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/api/laptops")
    public  List<Laptop> findLaptops(){

        return laptopRepository.findAll();
    }

    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findOneLaptopById(@PathVariable Long id){

        Optional<Laptop> optLaptop=laptopRepository.findById(id);
        if(optLaptop.isPresent())
            return ResponseEntity.ok(optLaptop.get());
        else
            return ResponseEntity.notFound().build();

    }

    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> createLaptop(@RequestBody Laptop laptop){

        if(laptop.getId()!=null) {
            log.warn("Trying to create an already existing laptop");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(laptopRepository.save(laptop));
    }

    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> updateLaptop(@RequestBody Laptop laptop){

        if(laptop.getId()==null) {//no existe, no tiene id
            log.warn("Trying to update an non existing laptop");
            return ResponseEntity.badRequest().build();
        }
        if(!laptopRepository.existsById(laptop.getId()))//no lo encuentra o se ha borrado sin actualizarse
        {
            log.warn("Trying to update an non existing laptop");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(laptopRepository.save(laptop));
    }

    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> deleteLaptop(@PathVariable Long id){

        if(!laptopRepository.existsById(id)){
            log.warn("Trying to delete a non existing laptop");
            return ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();//ok() con laptopRepository.delete da error pq delete no devuelve nada
    }

    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        log.warn("ATENCION!!! Vamos a borrar todos los laptops de la base de datos");
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
