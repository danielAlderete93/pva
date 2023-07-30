package com.veggie.veggieapp.controller;

import com.veggie.veggieapp.model.Order;
import com.veggie.veggieapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Endpoint para crear una nueva orden
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.create(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    // Endpoint para obtener una orden por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Integer id) {
        Order order = orderService.getById(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para obtener todas las órdenes
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAll();
        return ResponseEntity.ok(orders);
    }

    // Endpoint para actualizar una orden existente
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Integer id, @RequestBody Order order) {
        Order existingOrder = orderService.getById(id);
        if (existingOrder != null) {
            order.setId(id); // Asegurarse de que el ID de la orden sea el mismo que se está actualizando
            Order updatedOrder = orderService.update(order);
            return ResponseEntity.ok(updatedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para eliminar una orden por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer id) {
        Order existingOrder = orderService.getById(id);
        if (existingOrder != null) {
            orderService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

