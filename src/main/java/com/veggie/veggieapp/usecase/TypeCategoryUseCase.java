package com.veggie.veggieapp.usecase;

import com.veggie.veggieapp.dto.category.TypeCategoryDTO;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.TypeCategory;
import com.veggie.veggieapp.service.AbstractCrudService;
import org.springframework.stereotype.Component;

@Component
public class TypeCategoryUseCase extends AbstractCrudUseCase<TypeCategory, Integer, TypeCategoryDTO> {
    protected TypeCategoryUseCase(AbstractCrudService<TypeCategory, Integer> service, DtoMapper<TypeCategoryDTO, TypeCategory> mapper) {
        super(service, mapper);
    }

    @Override
    public TypeCategory update(Integer id, TypeCategoryDTO typeCategoryDTO) {
        TypeCategory typeCategory = mapper.toEntity(typeCategoryDTO);
        typeCategory.setId(id);
        return service.update(typeCategory);
    }
}
