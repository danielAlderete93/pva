package com.veggie.veggieapp.controller.v1;

import com.veggie.veggieapp.dto.request.category.CategoryRequestDTO;
import com.veggie.veggieapp.model.Category;
import com.veggie.veggieapp.usecase.abstracts.AbstractCategoryUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final AbstractCategoryUseCase categoryUseCase;

    @Autowired
    public CategoryController(AbstractCategoryUseCase categoryUseCase) {
        this.categoryUseCase = categoryUseCase;
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody CategoryRequestDTO categoryRequestDTO) {
        Category category = categoryUseCase.create(categoryRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer id) {
        Category category = categoryUseCase.findById(id);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Integer id, @RequestBody CategoryRequestDTO categoryRequestDTO) {
        Category updatedCategory = categoryUseCase.update(id, categoryRequestDTO);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
        boolean isDeleted = categoryUseCase.delete(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
