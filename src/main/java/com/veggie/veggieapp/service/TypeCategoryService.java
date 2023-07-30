package com.veggie.veggieapp.service;

import com.veggie.veggieapp.model.TypeCategory;
import com.veggie.veggieapp.repository.TypeCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeCategoryService extends AbstractCrudService<TypeCategory, Integer> {
    private final TypeCategoryRepository typeCategoryRepository;

    @Autowired
    public TypeCategoryService(TypeCategoryRepository typeCategoryRepository) {
        super(typeCategoryRepository);
        this.typeCategoryRepository = typeCategoryRepository;
    }

}

