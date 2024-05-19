package by.vstu.car.controller;

import by.vstu.car.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/orders")
public interface OrderController {

    @GetMapping
    ResponseEntity<List<Order>> getAllOrders();

    @GetMapping("/{id}")
    ResponseEntity<Order> getOrderById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<Order> createOrder(@RequestBody Order order);

    @PutMapping("/{id}")
    ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteOrder(@PathVariable Long id);
}
