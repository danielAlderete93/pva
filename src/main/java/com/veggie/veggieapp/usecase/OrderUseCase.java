package com.veggie.veggieapp.usecase;

import com.veggie.veggieapp.dto.order.OrderDTO;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.Order;
import com.veggie.veggieapp.service.AbstractCrudService;
import org.springframework.stereotype.Component;

@Component
public class OrderUseCase extends AbstractCrudUseCase<Order, Integer, OrderDTO> {
    protected OrderUseCase(AbstractCrudService<Order, Integer> service, DtoMapper<OrderDTO, Order> mapper) {
        super(service, mapper);
    }

    @Override
    public Order update(Integer id, OrderDTO orderDTO) {
        Order order = mapper.toEntity(orderDTO);
        order.setId(id);

        return service.update(order);
    }
}
