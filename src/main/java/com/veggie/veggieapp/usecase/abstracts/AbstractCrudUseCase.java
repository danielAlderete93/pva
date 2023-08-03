package com.veggie.veggieapp.usecase.abstracts;

import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.service.interfaces.CrudService;
import com.veggie.veggieapp.usecase.interfaces.CrudUseCase;

/**
 * An abstract base class for implementing common CRUD (Create, Read, Update, Delete) operations
 * in a use case.
 *
 * @param <E> The entity type used in the use case.
 * @param <K> The primary key type of the entity.
 * @param <T> The DTO (Data Transfer Object) type used for input.
 * @param <R> The response object type used for output.
 */
public abstract class AbstractCrudUseCase<E, K, T, R> implements CrudUseCase<K, T, R> {
    /**
     * The service responsible for performing CRUD operations on the entity.
     */
    protected final CrudService<E, K> service;

    /**
     * The mapper responsible for converting between DTOs and entities.
     */
    protected final DtoMapper<T, E, R> mapper;

    /**
     * Constructs an AbstractCrudUseCase with the provided CrudService and DtoMapper instances.
     *
     * @param service The CrudService implementation to be used.
     * @param mapper  The DtoMapper implementation to be used.
     */
    protected AbstractCrudUseCase(CrudService<E, K> service, DtoMapper<T, E, R> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    /**
     * Creates a new entity based on the input DTO and returns the mapped response object.
     *
     * @param t The input DTO representing the data to create the entity.
     * @return The response object representing the created entity.
     */
    @Override
    public R create(T t) {
        E e = mapper.toEntity(t);

        e = service.create(e);

        return mapper.toResponseDTO(e);
    }

    /**
     * Finds the entity by its primary key and returns the mapped response object.
     *
     * @param id The primary key of the entity to find.
     * @return The response object representing the found entity, or null if not found.
     */
    @Override
    public R findById(K id) {
        E e = service.getById(id);
        return mapper.toResponseDTO(e);
    }

    /**
     * Deletes the entity with the given primary key and returns true if the deletion was successful.
     *
     * @param id The primary key of the entity to delete.
     * @return True if the entity was successfully deleted, false otherwise.
     */
    @Override
    public boolean delete(K id) {
        E e;
        service.deleteById(id);
        e = service.getById(id);

        return e == null;
    }
}
