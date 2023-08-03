package com.veggie.veggieapp.service.interfaces;

import java.util.List;
/**
 * Generic interface representing common CRUD (Create, Read, Update, Delete) operations for entities.
 *
 * @param <T> The type of the entity to be managed.
 * @param <I> The type of the entity's primary key.
 */
public interface CrudService<T, I> {

    /**
     * Creates a new entity and saves it to the data store.
     *
     * @param entity The entity to be created and saved.
     * @return The created entity after it is saved.
     */
    T create(T entity);

    /**
     * Retrieves an entity by its primary key from the data store.
     *
     * @param i The primary key of the entity to retrieve.
     * @return The retrieved entity, or null if not found.
     */
    T getById(I i);

    /**
     * Retrieves all entities of the specified type from the data store.
     *
     * @return A list containing all entities of the specified type.
     */
    List<T> getAll();

    /**
     * Updates an existing entity in the data store.
     *
     * @param entity The entity to be updated.
     * @return The updated entity after the update operation is completed.
     */
    T update(T entity);

    /**
     * Deletes an entity with the given primary key from the data store.
     *
     * @param i The primary key of the entity to delete.
     */
    void deleteById(I i);
}
