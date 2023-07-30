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

    // Endpoint para crear un nuevo tipo de categoría
    @PostMapping(consumes = "application/json")
    public ResponseEntity<TypeCategory> createTypeCategory(@RequestBody TypeCategory typeCategory) {
        TypeCategory createdTypeCategory = typeCategoryService.create(typeCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTypeCategory);
    }

    // Endpoint para obtener un tipo de categoría por su ID
    @GetMapping("/{id}")
    public ResponseEntity<TypeCategory> getTypeCategoryById(@PathVariable Integer id) {
        TypeCategory typeCategory = typeCategoryService.getById(id);
        if (typeCategory != null) {
            return ResponseEntity.ok(typeCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para obtener todos los tipos de categoría
    @GetMapping
    public ResponseEntity<List<TypeCategory>> getAllTypeCategories() {
        List<TypeCategory> typeCategories = typeCategoryService.getAll();
        return ResponseEntity.ok(typeCategories);
    }

    // Endpoint para actualizar un tipo de categoría existente
    @PutMapping("/{id}")
    public ResponseEntity<TypeCategory> updateTypeCategory(@PathVariable Integer id, @RequestBody TypeCategory typeCategory) {
        TypeCategory existingTypeCategory = typeCategoryService.getById(id);
        if (existingTypeCategory != null) {
            typeCategory.setId(id); // Asegurarse de que el ID del tipo de categoría sea el mismo que se está actualizando
            TypeCategory updatedTypeCategory = typeCategoryService.update(typeCategory);
            return ResponseEntity.ok(updatedTypeCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para eliminar un tipo de categoría por su ID
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
