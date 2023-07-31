package com.veggie.veggieapp.controller.v1;

import com.veggie.veggieapp.dto.request.category.TypeCategoryRequestDTO;
import com.veggie.veggieapp.model.TypeCategory;
import com.veggie.veggieapp.usecase.abstracts.AbstractTypeCategoryUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories/type")
public class TypeCategoryController {

    private final AbstractTypeCategoryUseCase typeCategoryUseCase;

    @Autowired
    public TypeCategoryController(AbstractTypeCategoryUseCase typeCategoryUseCase) {
        this.typeCategoryUseCase = typeCategoryUseCase;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<TypeCategory> createTypeCategory(@RequestBody TypeCategoryRequestDTO typeCategoryRequestDTO) {
        TypeCategory createdTypeCategory = typeCategoryUseCase.create(typeCategoryRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTypeCategory);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeCategory> getTypeCategoryById(@PathVariable Integer id) {
        TypeCategory typeCategory = typeCategoryUseCase.findById(id);
        if (typeCategory != null) {
            return ResponseEntity.ok(typeCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<TypeCategory>> getAllTypeCategories() {
        List<TypeCategory> typeCategories = typeCategoryUseCase.findAll();
        return ResponseEntity.ok(typeCategories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeCategory> updateTypeCategory(@PathVariable Integer id, @RequestBody TypeCategoryRequestDTO typeCategory) {
        TypeCategory updatedType = typeCategoryUseCase.update(id, typeCategory);
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
