package com.veggie.veggieapp.usecase.interfaces;

import com.veggie.veggieapp.dto.request.order.ItemRequestDTO;
import com.veggie.veggieapp.dto.request.order.OrderRequestDTO;
import com.veggie.veggieapp.model.Order;

public interface OrderUseCase extends CrudUseCase<Order, Integer, OrderRequestDTO> {
    Order addItem(ItemRequestDTO itemRequestDTO);
}
