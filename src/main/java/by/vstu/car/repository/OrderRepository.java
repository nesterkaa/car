package by.vstu.car.repository;

import by.vstu.car.model.Order;
import by.vstu.car.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Vehicle> findDistinctByStatus(String status);
}

