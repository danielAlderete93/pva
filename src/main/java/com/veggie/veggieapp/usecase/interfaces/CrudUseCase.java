package com.veggie.veggieapp.usecase.interfaces;

/**
 * Generic interface representing common CRUD (Create, Read, Update, Delete) operations.
 *
 * @param <K> The type of the entity's primary key.
 * @param <T> The type of the DTO (Data Transfer Object) used for input.
 * @param <R> The type of the response object used for output.
 */
public interface CrudUseCase<K, T, R> {

    /**
     * Creates a new entity based on the input DTO and returns the response object representing the created entity.
     *
     * @param t The input DTO representing the data to create the entity.
     * @return The response object representing the created entity.
     */
    R create(T t);

    /**
     * Finds and retrieves an entity by its primary key and returns the response object representing the found entity.
     *
     * @param id The primary key of the entity to find.
     * @return The response object representing the found entity, or null if not found.
     */
    R findById(K id);

    /**
     * Updates an existing entity with the specified primary key based on the input DTO and returns the response object
     * representing the updated entity.
     *
     * @param id The primary key of the entity to update.
     * @param t  The input DTO representing the updated data for the entity.
     * @return The response object representing the updated entity.
     */
    R update(K id, T t);

    /**
     * Deletes the entity with the given primary key and returns true if the deletion was successful.
     *
     * @param id The primary key of the entity to delete.
     * @return True if the entity was successfully deleted, false otherwise.
     */
    boolean delete(K id);
}

