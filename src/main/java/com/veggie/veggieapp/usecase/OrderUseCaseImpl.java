package com.veggie.veggieapp.usecase;

import com.veggie.veggieapp.dto.request.ItemRequest;
import com.veggie.veggieapp.dto.request.OrderRequest;
import com.veggie.veggieapp.dto.response.ItemResponse;
import com.veggie.veggieapp.dto.response.OrderResponse;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.Item;
import com.veggie.veggieapp.model.Order;
import com.veggie.veggieapp.service.interfaces.OrderService;
import com.veggie.veggieapp.usecase.abstracts.AbstractCrudOrderUseCase;
import com.veggie.veggieapp.usecase.interfaces.OrderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderUseCaseImpl extends AbstractCrudOrderUseCase implements OrderUseCase {
    private final DtoMapper<ItemRequest, Item, ItemResponse> itemMapper;

    @Autowired
    public OrderUseCaseImpl(OrderService service, DtoMapper<OrderRequest, Order, OrderResponse> mapper, DtoMapper<ItemRequest, Item, ItemResponse> itemMapper) {
        super(service, mapper);
        this.itemMapper = itemMapper;
    }

    @Override
    public OrderResponse addItem(ItemRequest itemRequest) {
        Order order = service.getById(itemRequest.orderId());
        Item item = itemMapper.toEntity(itemRequest);

        order = ((OrderService) service).addItem(order, item);


        order = service.update(order);

        return mapper.toResponseDTO(order);


    }

    @Override
    public OrderResponse removeItem(ItemRequest itemRequest) {
        Order order = service.getById(itemRequest.orderId());
        Item item = itemMapper.toEntity(itemRequest);

        order = ((OrderService) service).removeItem(order, item);

        order = service.update(order);

        return mapper.toResponseDTO(order);
    }
}
