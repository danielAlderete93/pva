package com.veggie.veggieapp.controller.v1;

import com.veggie.veggieapp.dto.request.ItemRequest;
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
    @PostMapping("/add")
    public ResponseEntity<OrderResponse> addItem(@RequestBody ItemRequest itemRequest) {
        OrderResponse order = orderUseCase.addItem(itemRequest);
        return ResponseEntity.ok(order);
    }

}

