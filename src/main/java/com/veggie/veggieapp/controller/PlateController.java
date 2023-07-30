package com.veggie.veggieapp.controller;

import com.veggie.veggieapp.model.Plate;
import com.veggie.veggieapp.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plates")
public class PlateController {
    private PlateService plateService;

    @Autowired
    public PlateController(PlateService plateService) {
        this.plateService = plateService;
    }

    // Endpoint para crear una nueva placa
    @PostMapping
    public ResponseEntity<Plate> createPlate(@RequestBody Plate plate) {
        Plate createdPlate = plateService.create(plate);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlate);
    }

    // Endpoint para obtener una placa por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Plate> getPlateById(@PathVariable Integer id) {
        Plate plate = plateService.getById(id);
        if (plate != null) {
            return ResponseEntity.ok(plate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para obtener todas las placas
    @GetMapping
    public ResponseEntity<List<Plate>> getAllPlates() {
        List<Plate> plates = plateService.getAll();
        return ResponseEntity.ok(plates);
    }

    // Endpoint para actualizar una placa existente
    @PutMapping("/{id}")
    public ResponseEntity<Plate> updatePlate(@PathVariable Integer id, @RequestBody Plate plate) {
        Plate existingPlate = plateService.getById(id);
        if (existingPlate != null) {
            plate.setId(id); // Asegurarse de que el ID de la placa sea el mismo que se está actualizando
            Plate updatedPlate = plateService.update(plate);
            return ResponseEntity.ok(updatedPlate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para eliminar una placa por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlate(@PathVariable Integer id) {
        Plate existingPlate = plateService.getById(id);
        if (existingPlate != null) {
            plateService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
