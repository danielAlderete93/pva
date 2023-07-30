package com.veggie.veggieapp.mapper;

public interface DtoMapper<T, E> {
    E toEntity(T t);

    T toDTO(E e);

}
