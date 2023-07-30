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
    private final PlateService plateService;

    @Autowired
    public PlateController(PlateService plateService) {
        this.plateService = plateService;
    }

    @PostMapping
    public ResponseEntity<Plate> createPlate(@RequestBody Plate plate) {
        Plate createdPlate = plateService.create(plate);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlate);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plate> getPlateById(@PathVariable Integer id) {
        Plate plate = plateService.getById(id);
        if (plate != null) {
            return ResponseEntity.ok(plate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Plate>> getAllPlates() {
        List<Plate> plates = plateService.getAll();
        return ResponseEntity.ok(plates);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plate> updatePlate(@PathVariable Integer id, @RequestBody Plate plate) {
        Plate existingPlate = plateService.getById(id);
        if (existingPlate != null) {
            plate.setId(id);
            Plate updatedPlate = plateService.update(plate);
            return ResponseEntity.ok(updatedPlate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

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
