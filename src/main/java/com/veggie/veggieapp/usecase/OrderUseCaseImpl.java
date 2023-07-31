package com.veggie.veggieapp.usecase;

import com.veggie.veggieapp.dto.request.order.ItemRequestDTO;
import com.veggie.veggieapp.dto.request.order.OrderRequestDTO;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.Item;
import com.veggie.veggieapp.model.Order;
import com.veggie.veggieapp.service.interfaces.OrderService;
import com.veggie.veggieapp.usecase.abstracts.AbstractOrderUseCase;
import com.veggie.veggieapp.usecase.interfaces.OrderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderUseCaseImpl extends AbstractOrderUseCase implements OrderUseCase {
    private final DtoMapper<ItemRequestDTO, Item> itemMapper;

    @Autowired
    public OrderUseCaseImpl(OrderService service, DtoMapper<OrderRequestDTO, Order> mapper, DtoMapper<ItemRequestDTO, Item> itemMapper) {
        super(service, mapper);
        this.itemMapper = itemMapper;
    }

    @Override
    public Order addItem(ItemRequestDTO itemRequestDTO) {
        Order order = service.getById(itemRequestDTO.orderId());
        Item item = itemMapper.toEntity(itemRequestDTO);

        order = ((OrderService) service).addItem(order, item);


        return service.update(order);


    }
}
