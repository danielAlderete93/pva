package com.veggie.veggieapp.controller.v1;

import com.veggie.veggieapp.dto.request.TypeCategoryRequest;
import com.veggie.veggieapp.dto.response.TypeCategoryResponse;
import com.veggie.veggieapp.usecase.abstracts.AbstractCrudTypeCategoryUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories/type")
public class TypeCategoryController {

    private final AbstractCrudTypeCategoryUseCase typeCategoryUseCase;

    @Autowired
    public TypeCategoryController(AbstractCrudTypeCategoryUseCase typeCategoryUseCase) {
        this.typeCategoryUseCase = typeCategoryUseCase;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<TypeCategoryResponse> createTypeCategory(@RequestBody TypeCategoryRequest typeCategoryRequest) {
        TypeCategoryResponse createdTypeCategory = typeCategoryUseCase.create(typeCategoryRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTypeCategory);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeCategoryResponse> getTypeCategoryById(@PathVariable Integer id) {
        TypeCategoryResponse typeCategory = typeCategoryUseCase.findById(id);
        if (typeCategory != null) {
            return ResponseEntity.ok(typeCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<TypeCategoryResponse>> getAllTypeCategories() {
        List<TypeCategoryResponse> typeCategories = typeCategoryUseCase.findAll();
        return ResponseEntity.ok(typeCategories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeCategoryResponse> updateTypeCategory(@PathVariable Integer id, @RequestBody TypeCategoryRequest typeCategory) {
        TypeCategoryResponse updatedType = typeCategoryUseCase.update(id, typeCategory);
        return ResponseEntity.ok(updatedType);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeCategory(@PathVariable Integer id) {
        boolean isDeleted = typeCategoryUseCase.delete(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
