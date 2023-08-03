package com.veggie.veggieapp.service.abstracts;

import com.veggie.veggieapp.service.interfaces.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Abstract class providing common CRUD (Create, Read, Update, Delete) operations for entities using a JpaRepository.
 *
 * @param <T> The type of the entity to be managed.
 * @param <I> The type of the entity's primary key.
 */
public abstract class AbstractCrudService<T, I> implements CrudService<T, I> {
    protected final JpaRepository<T, I> repository;

    /**
     * Constructs the AbstractCrudService with the required JpaRepository.
     *
     * @param repository The JpaRepository responsible for data access and manipulation of the entity.
     */
    protected AbstractCrudService(JpaRepository<T, I> repository) {
        this.repository = repository;
    }

    /**
     * Creates a new entity in the database.
     *
     * @param entity The entity to be created.
     * @return The created entity.
     */
    @Override
    public T create(T entity) {
        return repository.save(entity);
    }

    /**
     * Retrieves an entity from the database by its primary key.
     *
     * @param i The primary key of the entity to be retrieved.
     * @return The retrieved entity, or null if not found.
     */
    @Override
    public T getById(I i) {
        return repository.findById(i).orElse(null);
    }

    /**
     * Retrieves all entities from the database.
     *
     * @return A list of all entities in the database.
     */
    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    /**
     * Updates an existing entity in the database.
     *
     * @param entity The entity to be updated.
     * @return The updated entity.
     */
    @Override
    public T update(T entity) {
        return repository.save(entity);
    }

    /**
     * Deletes an entity from the database by its primary key.
     *
     * @param i The primary key of the entity to be deleted.
     */
    @Override
    public void deleteById(I i) {
        repository.deleteById(i);
    }

}
