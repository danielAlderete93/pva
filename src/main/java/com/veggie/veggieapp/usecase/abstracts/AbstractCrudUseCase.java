package com.veggie.veggieapp.usecase.abstracts;

import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.service.interfaces.CrudService;
import com.veggie.veggieapp.usecase.interfaces.CrudUseCase;

public abstract class AbstractCrudUseCase<E, K, T, R> implements CrudUseCase<K, T, R> {
    protected final CrudService<E, K> service;
    protected final DtoMapper<T, E, R> mapper;

    protected AbstractCrudUseCase(CrudService<E, K> service, DtoMapper<T, E, R> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public R create(T t) {
        E e = mapper.toEntity(t);

        e = service.create(e);

        return mapper.toResponseDTO(e);
    }

    @Override
    public R findById(K id) {
        E e = service.getById(id);
        return mapper.toResponseDTO(e);
    }



    @Override
    public boolean delete(K id) {
        E e;
        service.deleteById(id);
        e = service.getById(id);

        return e == null;
    }


}
