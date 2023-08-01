package com.veggie.veggieapp.usecase.abstracts;

import com.veggie.veggieapp.dto.request.OrderRequest;
import com.veggie.veggieapp.dto.response.OrderResponse;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.Order;
import com.veggie.veggieapp.service.interfaces.CrudService;

public abstract class AbstractCrudOrderUseCase extends AbstractCrudUseCase<Order, Integer, OrderRequest, OrderResponse> {


    protected AbstractCrudOrderUseCase(CrudService<Order, Integer> service, DtoMapper<OrderRequest, Order, OrderResponse> mapper) {
        super(service, mapper);
    }

    @Override
    public OrderResponse update(Integer id, OrderRequest orderRequestDTO) {
        Order order = mapper.toEntity(orderRequestDTO);
        order.setId(id);
        order = service.update(order);

        return mapper.toResponseDTO(order);
    }
}