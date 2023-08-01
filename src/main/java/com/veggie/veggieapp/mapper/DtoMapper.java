package com.veggie.veggieapp.mapper;

public interface DtoMapper<T, E, R> {
    E toEntity(T t);

    T toRequestDTO(E e);

    R toResponseDTO(E e);

}
