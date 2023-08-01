package com.veggie.veggieapp.usecase.interfaces;

public interface CrudUseCase<K, T, R> {
    R create(T t);

    R findById(K id);

    R update(K id, T t);


    boolean delete(K id);
}
