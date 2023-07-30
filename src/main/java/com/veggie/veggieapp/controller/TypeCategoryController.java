package com.veggie.veggieapp.controller;

import com.veggie.veggieapp.model.TypeCategory;
import com.veggie.veggieapp.service.TypeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories/type")
public class TypeCategoryController {
    private final TypeCategoryService typeCategoryService;

    @Autowired
    public TypeCategoryController(TypeCategoryService typeCategoryService) {
        this.typeCategoryService = typeCategoryService;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<TypeCategory> createTypeCategory(@RequestBody TypeCategory typeCategory) {
        TypeCategory createdTypeCategory = typeCategoryService.create(typeCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTypeCategory);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeCategory> getTypeCategoryById(@PathVariable Integer id) {
        TypeCategory typeCategory = typeCategoryService.getById(id);
        if (typeCategory != null) {
            return ResponseEntity.ok(typeCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<TypeCategory>> getAllTypeCategories() {
        List<TypeCategory> typeCategories = typeCategoryService.getAll();
        return ResponseEntity.ok(typeCategories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeCategory> updateTypeCategory(@PathVariable Integer id, @RequestBody TypeCategory typeCategory) {
        TypeCategory existingTypeCategory = typeCategoryService.getById(id);
        if (existingTypeCategory != null) {
            typeCategory.setId(id);
            TypeCategory updatedTypeCategory = typeCategoryService.update(typeCategory);
            return ResponseEntity.ok(updatedTypeCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeCategory(@PathVariable Integer id) {
        TypeCategory existingTypeCategory = typeCategoryService.getById(id);
        if (existingTypeCategory != null) {
            typeCategoryService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
