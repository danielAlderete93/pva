package com.veggie.veggieapp.controller.v1;

import com.veggie.veggieapp.dto.request.OrderRequest;
import com.veggie.veggieapp.dto.response.OrderResponse;
import com.veggie.veggieapp.usecase.interfaces.OrderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderUseCase orderUseCase;

    @Autowired
    public OrderController(OrderUseCase orderUseCase) {
        this.orderUseCase = orderUseCase;
    }

    //CRUD ENDPOINTS
    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequestDTO) {
        OrderResponse createdOrder = orderUseCase.create(orderRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Integer id) {
        OrderResponse order = orderUseCase.findById(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<OrderResponse> updateOrder(@PathVariable Integer id, @RequestBody OrderRequest order) {
        OrderResponse updatedOrder = orderUseCase.update(id, order);
        return ResponseEntity.ok(updatedOrder);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer id) {
        boolean isDeleted = orderUseCase.delete(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //ENDPOINTS FUNCTIONAL
    @PostMapping("{orderId}/add/{foodId}/")
    public ResponseEntity<OrderResponse> addItem(@PathVariable Integer orderId, @PathVariable Integer foodId, @RequestParam int quantity) {
        OrderResponse order = orderUseCase.addItemToOrder(orderId, foodId, quantity);
        return ResponseEntity.ok(order);
    }

    @PostMapping("{orderId}/remove/{foodId}")
    public ResponseEntity<OrderResponse> removeItem(@PathVariable Integer orderId, @PathVariable Integer foodId) {
        OrderResponse order = orderUseCase.removeItemFromOrder(orderId, foodId);
        return ResponseEntity.ok(order);
    }

    @PostMapping("/{orderId}/items/{foodId}/increase-quantity")
    public ResponseEntity<OrderResponse> addQuantityToItemInOrder(@PathVariable Integer orderId, @PathVariable Integer foodId, @RequestParam int quantity) {
        OrderResponse order = orderUseCase.incrementQuantityInOrder(orderId, foodId, quantity);
        return ResponseEntity.ok(order);
    }

    @PostMapping("/{orderId}/items/{itemId}/reduce-quantity")
    public ResponseEntity<OrderResponse> reduceQuantityToItemInOrder(@PathVariable Integer orderId, @PathVariable Integer itemId, @RequestParam int quantity) {
        OrderResponse order = orderUseCase.reduceQuantityInOrder(orderId, itemId, quantity);
        return ResponseEntity.ok(order);
    }

}

