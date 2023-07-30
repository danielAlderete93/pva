package com.veggie.veggieapp.service;

import com.veggie.veggieapp.model.Category;
import com.veggie.veggieapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends AbstractCrudService<Category, Integer> {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        super(categoryRepository);
        this.categoryRepository = categoryRepository;
    }

}

