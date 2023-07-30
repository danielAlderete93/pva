package com.veggie.veggieapp.mapper;

import com.veggie.veggieapp.dto.order.OrderDTO;
import com.veggie.veggieapp.model.Address;
import com.veggie.veggieapp.model.Order;
import com.veggie.veggieapp.model.OrderStatus;
import com.veggie.veggieapp.model.User;
import com.veggie.veggieapp.service.AbstractCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class OrderMapper implements DtoMapper<OrderDTO, Order> {
    private final AbstractCrudService<User, Integer> userService;
    private final AbstractCrudService<Address, Integer> addressService;

    @Autowired
    public OrderMapper(AbstractCrudService<User, Integer> userService, AbstractCrudService<Address, Integer> addressService) {
        this.userService = userService;
        this.addressService = addressService;
    }

    @Override
    public Order toEntity(OrderDTO orderDTO) {
        Address address = addressService.getById(orderDTO.addressId());
        User user = userService.getById(orderDTO.userId());

        return Order.builder()
                .address(address)
                .customer(user)
                .items(new ArrayList<>())
                .status(OrderStatus.READY_TO_ORDER)
                .build();
    }

    @Override
    public OrderDTO toDTO(Order order) {
        User user = order.getCustomer();
        Address address = order.getAddress();
        OrderStatus status = order.getStatus();

        return new OrderDTO(user.getId(), address.getId(), status.ordinal());
    }
}
