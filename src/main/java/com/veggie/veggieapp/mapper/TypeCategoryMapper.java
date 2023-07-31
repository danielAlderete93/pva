package com.veggie.veggieapp.mapper;

import com.veggie.veggieapp.dto.request.category.TypeCategoryRequestDTO;
import com.veggie.veggieapp.model.TypeCategory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class TypeCategoryMapper implements DtoMapper<TypeCategoryRequestDTO, TypeCategory> {

    @Override
    public TypeCategory toEntity(TypeCategoryRequestDTO typeCategoryRequestDTO) {

        return TypeCategory.builder()
                .categories(new ArrayList<>())
                .description(typeCategoryRequestDTO.description())
                .name(typeCategoryRequestDTO.name())
                .build();
    }

    @Override
    public TypeCategoryRequestDTO toDTO(TypeCategory typeCategory) {
        return new TypeCategoryRequestDTO(typeCategory.getName(), typeCategory.getDescription());
    }
}
