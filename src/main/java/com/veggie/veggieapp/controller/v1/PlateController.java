package com.veggie.veggieapp.controller.v1;

import com.veggie.veggieapp.dto.request.plate.FoodDTO;
import com.veggie.veggieapp.model.Food;
import com.veggie.veggieapp.usecase.abstracts.AbstractPlateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/food")
public class PlateController {
    private final AbstractPlateUseCase plateUseCase;

    @Autowired
    public PlateController(AbstractPlateUseCase plateUseCase) {
        this.plateUseCase = plateUseCase;
    }

    @PostMapping
    public ResponseEntity<Food> createFood(@RequestBody FoodDTO plate) {
        Food createdFood = plateUseCase.create(plate);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFood);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable Integer id) {
        Food food = plateUseCase.findById(id);
        if (food != null) {
            return ResponseEntity.ok(food);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Food>> getAllFoods() {
        List<Food> foods = plateUseCase.findAll();
        return ResponseEntity.ok(foods);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable Integer id, @RequestBody FoodDTO plate) {
        Food updatedFood = plateUseCase.update(id, plate);
        return ResponseEntity.ok(updatedFood);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable Integer id) {
        boolean isDeleted = plateUseCase.delete(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
