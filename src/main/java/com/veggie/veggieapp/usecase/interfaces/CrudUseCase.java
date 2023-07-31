package com.veggie.veggieapp.usecase.interfaces;

public interface CrudUseCase<E, K, T> {
    E create(T t);

    E findById(K id);

    E update(K id, T t);


    boolean delete(K id);
}
