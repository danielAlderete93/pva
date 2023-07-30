package com.veggie.veggieapp.controller;

import com.veggie.veggieapp.model.Category;
import com.veggie.veggieapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<EntityModel<Category>> createCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.create(category);
        EntityModel<Category> categoryResource = EntityModel.of(createdCategory);
        categoryResource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CategoryController.class).getCategoryById(createdCategory.getId())).withSelfRel());
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryResource);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Category>> getCategoryById(@PathVariable Integer id) {
        Category category = categoryService.getById(id);
        if (category != null) {
            EntityModel<Category> categoryResource = EntityModel.of(category);
            categoryResource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CategoryController.class).getCategoryById(id)).withSelfRel());
            return ResponseEntity.ok(categoryResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<EntityModel<Category>>> getAllCategories() {
        List<Category> categories = categoryService.getAll();
        List<EntityModel<Category>> categoryResources = categories.stream()
                .map(category -> {
                    EntityModel<Category> categoryResource = EntityModel.of(category);
                    categoryResource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CategoryController.class).getCategoryById(category.getId())).withSelfRel());
                    return categoryResource;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(categoryResources);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<Category>> updateCategory(@PathVariable Integer id, @RequestBody Category category) {
        Category existingCategory = categoryService.getById(id);
        if (existingCategory != null) {
            category.setId(id);
            Category updatedCategory = categoryService.update(category);
            EntityModel<Category> categoryResource = EntityModel.of(updatedCategory);
            categoryResource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CategoryController.class).getCategoryById(updatedCategory.getId())).withSelfRel());
            return ResponseEntity.ok(categoryResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
        Category existingCategory = categoryService.getById(id);
        if (existingCategory != null) {
            categoryService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
