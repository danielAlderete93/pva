package com.veggie.veggieapp.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractCrudService<T, I> {
    protected final JpaRepository<T, I> repository;

    protected AbstractCrudService(JpaRepository<T, I> repository) {
        this.repository = repository;
    }

    public T create(T entity) {
        return repository.save(entity);
    }

    public T getById(I i) {
        return repository.findById(i).orElse(null);
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public T update(T entity) {
        return repository.save(entity);
    }

    public void deleteById(I i) {
        repository.deleteById(i);
    }

}
