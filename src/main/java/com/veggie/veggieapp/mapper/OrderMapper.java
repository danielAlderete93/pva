package com.veggie.veggieapp.mapper;

import com.veggie.veggieapp.dto.request.ItemRequest;
import com.veggie.veggieapp.dto.request.OrderRequest;
import com.veggie.veggieapp.dto.response.ItemResponse;
import com.veggie.veggieapp.dto.response.OrderResponse;
import com.veggie.veggieapp.model.*;
import com.veggie.veggieapp.service.abstracts.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper implements DtoMapper<OrderRequest, Order, OrderResponse> {
    private final AbstractCrudService<User, Integer> userService;
    private final AbstractCrudService<Address, Integer> addressService;

    private final DtoMapper<ItemRequest, Item, ItemResponse> itemMapper;


    @Autowired
    public OrderMapper(AbstractCrudService<User, Integer> userService, AbstractCrudService<Address, Integer> addressService, DtoMapper<ItemRequest, Item, ItemResponse> itemMapper) {
        this.userService = userService;
        this.addressService = addressService;
        this.itemMapper = itemMapper;
    }

    @Override
    public Order toEntity(OrderRequest orderRequestDTO) {
        Address address = addressService.getById(orderRequestDTO.addressId());
        User user = userService.getById(orderRequestDTO.userId());

        return Order.builder()
                .address(address)
                .customer(user)
                .items(new ArrayList<>())
                .status(OrderStatus.READY_TO_ORDER)
                .build();
    }

    @Override
    public OrderRequest toRequestDTO(Order order) {
        User user = order.getCustomer();
        Address address = order.getAddress();

        return new OrderRequest(user.getId(), address.getId());
    }

    @Override
    public OrderResponse toResponseDTO(Order order) {
        User user = order.getCustomer();
        Address address = order.getAddress();
        List<ItemResponse> itemList = new ArrayList<>();

        if (!order.getItems().isEmpty()) {
            itemList = order.getItems().stream()
                    .map(itemMapper::toResponseDTO)
                    .toList()
            ;
        }

        return new OrderResponse(
                order.getId(),
                user.getId(),
                itemList,
                address.getId(),
                order.getStatus().ordinal(),
                order.getTotal()
        );
    }
}
