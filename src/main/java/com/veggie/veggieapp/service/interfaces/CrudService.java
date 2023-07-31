package com.veggie.veggieapp.service.interfaces;

import java.util.List;

public interface CrudService<T, I> {
    T create(T entity);

    T getById(I i);

    List<T> getAll();

    T update(T entity);

    void deleteById(I i);
}
