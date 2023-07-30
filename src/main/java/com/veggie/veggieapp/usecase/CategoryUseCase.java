package com.veggie.veggieapp.usecase;

import com.veggie.veggieapp.dto.category.CategoryDTO;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.Category;
import com.veggie.veggieapp.service.AbstractCrudService;
import org.springframework.stereotype.Component;

@Component
public class CategoryUseCase extends AbstractCrudUseCase<Category, Integer, CategoryDTO> {
    public CategoryUseCase(AbstractCrudService<Category, Integer> service, DtoMapper<CategoryDTO, Category> mapper) {
        super(service, mapper);
    }

    @Override
    public Category update(Integer id, CategoryDTO categoryDTO) {
        Category category = mapper.toEntity(categoryDTO);
        category.setId(id);
        return service.update(category);
    }


}
