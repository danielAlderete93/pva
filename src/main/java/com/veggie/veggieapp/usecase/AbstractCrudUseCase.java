package com.veggie.veggieapp.usecase;

import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.service.AbstractCrudService;

public abstract class AbstractCrudUseCase<E, K, T> {
    protected final AbstractCrudService<E, K> service;
    protected final DtoMapper<T, E> mapper;

    protected AbstractCrudUseCase(AbstractCrudService<E, K> service, DtoMapper<T, E> mapper) {
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


    public Boolean delete(K id) {
        E e;
        service.deleteById(id);
        e = service.getById(id);

        return e == null;
    }


}
