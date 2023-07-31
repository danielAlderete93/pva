package com.veggie.veggieapp.controller.v1;

import com.veggie.veggieapp.dto.request.order.ItemRequestDTO;
import com.veggie.veggieapp.dto.request.order.OrderRequestDTO;
import com.veggie.veggieapp.model.Order;
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
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        Order createdOrder = orderUseCase.create(orderRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Integer id) {
        Order order = orderUseCase.findById(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Integer id, @RequestBody OrderRequestDTO order) {
        Order updatedOrder = orderUseCase.update(id, order);
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
    public ResponseEntity<Order> addItem(@RequestBody ItemRequestDTO itemRequestDTO) {
        Order order = orderUseCase.addItem(itemRequestDTO);
        return ResponseEntity.ok(order);
    }

}

