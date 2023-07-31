package com.veggie.veggieapp.service;

import com.veggie.veggieapp.model.TypeCategory;
import com.veggie.veggieapp.repository.TypeCategoryRepository;
import com.veggie.veggieapp.service.interfaces.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeCategoryService extends AbstractCrudService<TypeCategory, Integer> {

    @Autowired
    public TypeCategoryService(TypeCategoryRepository typeCategoryRepository) {
        super(typeCategoryRepository);
    }

}

