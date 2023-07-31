package com.veggie.veggieapp.service.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractCrudService<T, I> implements CrudService<T, I> {
    protected final JpaRepository<T, I> repository;

    protected AbstractCrudService(JpaRepository<T, I> repository) {
        this.repository = repository;
    }

    @Override
    public T create(T entity) {
        return repository.save(entity);
    }

    @Override
    public T getById(I i) {
        return repository.findById(i).orElse(null);
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public T update(T entity) {
        return repository.save(entity);
    }

    @Override
    public void deleteById(I i) {
        repository.deleteById(i);
    }

}
