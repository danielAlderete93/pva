package com.veggie.veggieapp.mapper;

import com.veggie.veggieapp.dto.category.TypeCategoryDTO;
import com.veggie.veggieapp.model.TypeCategory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class TypeCategoryMapper implements DtoMapper<TypeCategoryDTO, TypeCategory> {

    @Override
    public TypeCategory toEntity(TypeCategoryDTO typeCategoryDTO) {

        return TypeCategory.builder()
                .categories(new ArrayList<>())
                .description(typeCategoryDTO.description())
                .name(typeCategoryDTO.name())
                .build();
    }

    @Override
    public TypeCategoryDTO toDTO(TypeCategory typeCategory) {
        return new TypeCategoryDTO(typeCategory.getName(), typeCategory.getDescription());
    }
}
