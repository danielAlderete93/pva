package com.veggie.veggieapp.mapper;

import com.veggie.veggieapp.dto.request.order.OrderRequestDTO;
import com.veggie.veggieapp.model.Address;
import com.veggie.veggieapp.model.Order;
import com.veggie.veggieapp.model.OrderStatus;
import com.veggie.veggieapp.model.User;
import com.veggie.veggieapp.service.interfaces.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class OrderMapper implements DtoMapper<OrderRequestDTO, Order> {
    private final AbstractCrudService<User, Integer> userService;
    private final AbstractCrudService<Address, Integer> addressService;

    @Autowired
    public OrderMapper(AbstractCrudService<User, Integer> userService, AbstractCrudService<Address, Integer> addressService) {
        this.userService = userService;
        this.addressService = addressService;
    }

    @Override
    public Order toEntity(OrderRequestDTO orderRequestDTO) {
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
    public OrderRequestDTO toDTO(Order order) {
        User user = order.getCustomer();
        Address address = order.getAddress();

        return new OrderRequestDTO(user.getId(), address.getId());
    }
}
