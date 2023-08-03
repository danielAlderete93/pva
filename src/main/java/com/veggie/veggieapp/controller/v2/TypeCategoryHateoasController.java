package com.veggie.veggieapp.controller.v2;

import com.veggie.veggieapp.model.TypeCategory;
import com.veggie.veggieapp.service.abstracts.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v2/categories/type")
public class TypeCategoryHateoasController {

    private final AbstractCrudService<TypeCategory, Integer> typeCategoryService;

    @Autowired
    public TypeCategoryHateoasController(AbstractCrudService<TypeCategory, Integer> typeCategoryService) {
        this.typeCategoryService = typeCategoryService;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<EntityModel<TypeCategory>> createTypeCategory(@RequestBody TypeCategory typeCategory) {
        TypeCategory createdTypeCategory = typeCategoryService.create(typeCategory);
        EntityModel<TypeCategory> typeCategoryResource = EntityModel.of(createdTypeCategory);
        typeCategoryResource.add(linkTo(methodOn(TypeCategoryHateoasController.class).getTypeCategoryById(createdTypeCategory.getId())).withSelfRel());
        return ResponseEntity.status(HttpStatus.CREATED).body(typeCategoryResource);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<TypeCategory>> getTypeCategoryById(@PathVariable Integer id) {
        TypeCategory typeCategory = typeCategoryService.getById(id);
        if (typeCategory != null) {
            EntityModel<TypeCategory> typeCategoryResource = EntityModel.of(typeCategory);
            typeCategoryResource.add(linkTo(methodOn(TypeCategoryHateoasController.class).getTypeCategoryById(id)).withSelfRel());
            return ResponseEntity.ok(typeCategoryResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<EntityModel<TypeCategory>>> getAllTypeCategories() {
        List<TypeCategory> typeCategories = typeCategoryService.getAll();
        List<EntityModel<TypeCategory>> typeCategoryResources = typeCategories.stream()
                .map(typeCategory -> {
                    EntityModel<TypeCategory> typeCategoryResource = EntityModel.of(typeCategory);
                    typeCategoryResource.add(linkTo(methodOn(TypeCategoryHateoasController.class).getTypeCategoryById(typeCategory.getId())).withSelfRel());
                    return typeCategoryResource;
                })
                .toList();
        return ResponseEntity.ok(typeCategoryResources);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<TypeCategory>> updateTypeCategory(@PathVariable Integer id, @RequestBody TypeCategory typeCategory) {
        TypeCategory existingTypeCategory = typeCategoryService.getById(id);
        if (existingTypeCategory != null) {
            typeCategory.setId(id);
            TypeCategory updatedTypeCategory = typeCategoryService.update(typeCategory);
            EntityModel<TypeCategory> typeCategoryResource = EntityModel.of(updatedTypeCategory);
            typeCategoryResource.add(linkTo(methodOn(TypeCategoryHateoasController.class).getTypeCategoryById(updatedTypeCategory.getId())).withSelfRel());
            return ResponseEntity.ok(typeCategoryResource);
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
