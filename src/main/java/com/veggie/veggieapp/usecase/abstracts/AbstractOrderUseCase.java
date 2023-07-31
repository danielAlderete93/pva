package com.veggie.veggieapp.usecase.abstracts;

import com.veggie.veggieapp.dto.request.order.OrderRequestDTO;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.Order;
import com.veggie.veggieapp.service.interfaces.CrudService;

public abstract class AbstractOrderUseCase extends AbstractCrudUseCase<Order, Integer, OrderRequestDTO> {


    protected AbstractOrderUseCase(CrudService<Order, Integer> service, DtoMapper<OrderRequestDTO, Order> mapper) {
        super(service, mapper);
    }

    @Override
    public Order update(Integer id, OrderRequestDTO orderRequestDTO) {
        Order order = mapper.toEntity(orderRequestDTO);
        order.setId(id);

        return service.update(order);
    }


}