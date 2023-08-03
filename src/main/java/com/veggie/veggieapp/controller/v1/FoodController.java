package com.veggie.veggieapp.controller.v1;

import com.veggie.veggieapp.dto.request.FoodRequest;
import com.veggie.veggieapp.dto.response.FoodResponse;
import com.veggie.veggieapp.usecase.interfaces.FoodUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/food")
public class FoodController {
    private final FoodUseCase foodUseCase;

    public FoodController(FoodUseCase foodUseCase) {
        this.foodUseCase = foodUseCase;
    }

    @PostMapping
    public ResponseEntity<FoodResponse> createFood(@RequestBody FoodRequest plate) {
        FoodResponse createdFood = foodUseCase.create(plate);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFood);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodResponse> getFoodById(@PathVariable Integer id) {
        FoodResponse food = foodUseCase.findById(id);
        if (food != null) {
            return ResponseEntity.ok(food);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<FoodResponse>> getAllFoods() {
        List<FoodResponse> foods = foodUseCase.findAll();
        return ResponseEntity.ok(foods);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodResponse> updateFood(@PathVariable Integer id, @RequestBody FoodRequest plate) {
        FoodResponse updatedFood = foodUseCase.update(id, plate);
        return ResponseEntity.ok(updatedFood);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable Integer id) {
        boolean isDeleted = foodUseCase.delete(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
