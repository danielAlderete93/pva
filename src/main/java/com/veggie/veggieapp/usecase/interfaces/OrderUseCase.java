package com.veggie.veggieapp.usecase.interfaces;

import com.veggie.veggieapp.dto.request.ItemRequest;
import com.veggie.veggieapp.dto.request.OrderRequest;
import com.veggie.veggieapp.dto.response.OrderResponse;

public interface OrderUseCase extends CrudUseCase<Integer, OrderRequest,OrderResponse> {
    OrderResponse addItem(ItemRequest itemRequest);

    OrderResponse removeItem(ItemRequest itemRequest);
}
