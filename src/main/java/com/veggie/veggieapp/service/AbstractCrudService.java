package com.veggie.veggieapp.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractCrudService<T, ID> {
    private final JpaRepository<T, ID> repository;

    public AbstractCrudService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public T create(T entity) {
        return repository.save(entity);
    }

    public T getById(ID id) {
        return repository.findById(id).orElse(null);
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public T update(T entity) {
        return repository.save(entity);
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    // Otros métodos específicos del servicio que puedas necesitar
}
