package com.veggie.veggieapp.usecase.abstracts;

import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.service.interfaces.CrudService;

public abstract class AbstractCrudUseCase<E, K, T> {
    protected final CrudService<E, K> service;
    protected final DtoMapper<T, E> mapper;

    protected AbstractCrudUseCase(CrudService<E, K> service, DtoMapper<T, E> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    public E create(T t) {
        E e = mapper.toEntity(t);

        e = service.create(e);

        return e;
    }

    public E findById(K id) {
        return service.getById(id);
    }

    public abstract E update(K id, T t);


    public boolean delete(K id) {
        E e;
        service.deleteById(id);
        e = service.getById(id);

        return e == null;
    }


}
