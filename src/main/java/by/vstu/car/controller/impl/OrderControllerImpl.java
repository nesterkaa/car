package by.vstu.car.controller.impl;

import by.vstu.car.controller.OrderController;
import by.vstu.car.model.Order;
import by.vstu.car.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderControllerImpl implements OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderRepository.findAll());
    }

    @Override
    public ResponseEntity<Order> getOrderById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Order> createOrder(Order order) {
        return ResponseEntity.ok(orderRepository.save(order));
    }

    @Override
    public ResponseEntity<Order> updateOrder(Long id, Order order) {
        if (!orderRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        order.setId(id);
        return ResponseEntity.ok(orderRepository.save(order));
    }

    @Override
    public ResponseEntity<Void> deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        orderRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}