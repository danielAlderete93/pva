package com.veggie.veggieapp.usecase;

import com.veggie.veggieapp.dto.request.OrderRequest;
import com.veggie.veggieapp.dto.response.OrderResponse;
import com.veggie.veggieapp.mapper.DtoMapper;
import com.veggie.veggieapp.model.Food;
import com.veggie.veggieapp.model.Order;
import com.veggie.veggieapp.service.interfaces.FoodService;
import com.veggie.veggieapp.service.interfaces.OrderService;
import com.veggie.veggieapp.usecase.abstracts.AbstractCrudUseCase;
import com.veggie.veggieapp.usecase.interfaces.OrderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Concrete implementation of the OrderUseCase interface for managing orders.
 * Extends the AbstractCrudUseCase class to inherit common CRUD operations.
 */
@Component
public class OrderUseCaseImpl extends AbstractCrudUseCase<Order, Integer, OrderRequest, OrderResponse> implements OrderUseCase {
    private final FoodService foodService;

    /**
     * Constructs the OrderUseCaseImpl with the required dependencies.
     *
     * @param service     The OrderService implementation responsible for managing orders.
     * @param mapper      The DtoMapper responsible for mapping OrderRequest to Order and OrderResponse to Order.
     * @param foodService The FoodService implementation responsible for managing food items.
     */
    @Autowired
    public OrderUseCaseImpl(OrderService service, DtoMapper<OrderRequest, Order, OrderResponse> mapper, FoodService foodService) {
        super(service, mapper);
        this.foodService = foodService;
    }

    @Override
    public OrderResponse update(Integer id, OrderRequest orderRequestDTO) {
        Order order = mapper.toEntity(orderRequestDTO);
        order.setId(id);
        order = service.update(order);

        return mapper.toResponseDTO(order);
    }

    @Override
    public OrderResponse addItemToOrder(Integer orderId, Integer foodId, Integer quantity) {
        Order order = service.getById(orderId);
        Food food = foodService.getById(foodId);

        order = ((OrderService) service).addItem(order, food, quantity);

        return mapper.toResponseDTO(order);
    }

    @Override
    public OrderResponse removeItemFromOrder(Integer orderId, Integer foodId) {
        Order order = service.getById(orderId);
        Food food = foodService.getById(foodId);

        order = ((OrderService) service).removeItem(order, food);

        return mapper.toResponseDTO(order);
    }

    @Override
    public OrderResponse incrementQuantityInOrder(Integer orderId, Integer foodId, Integer quantity) {
        Order order = service.getById(orderId);
        Food food = foodService.getById(foodId);

        order = ((OrderService) service).incrementQuantity(order, food, quantity);

        return mapper.toResponseDTO(order);
    }

    @Override
    public OrderResponse reduceQuantityInOrder(Integer orderId, Integer foodId, Integer quantity) {
        Order order = service.getById(orderId);
        Food food = foodService.getById(foodId);

        order = ((OrderService) service).reduceQuantity(order, food, quantity);

        return mapper.toResponseDTO(order);
    }
}
