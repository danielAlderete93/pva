package com.veggie.veggieapp.usecase.abstracts;

import com.veggie.veggieapp.dto.request.category.CategoryRequestDTO;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.Category;
import com.veggie.veggieapp.service.interfaces.CrudService;

public abstract class AbstractCategoryUseCase extends AbstractCrudUseCase<Category, Integer, CategoryRequestDTO> {

    protected AbstractCategoryUseCase(CrudService<Category, Integer> service, DtoMapper<CategoryRequestDTO, Category> mapper) {
        super(service, mapper);
    }

    @Override
    public Category update(Integer id, CategoryRequestDTO categoryRequestDTO) {
        Category category = mapper.toEntity(categoryRequestDTO);
        category.setId(id);
        return service.update(category);
    }
}
