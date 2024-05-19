package by.vstu.car.controller.impl;

import by.vstu.car.controller.VehicleController;
import by.vstu.car.model.Vehicle;
import by.vstu.car.repository.OrderRepository;
import by.vstu.car.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class VehicleControllerImpl implements VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        return ResponseEntity.ok(vehicleRepository.findAll());
    }

    @Override
    public ResponseEntity<Vehicle> getVehicleById(Long id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        return vehicle.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Vehicle> createVehicle(Vehicle vehicle) {
        return ResponseEntity.ok(vehicleRepository.save(vehicle));
    }

    @Override
    public ResponseEntity<List<Vehicle>> getVehiclesByClientId(Long clientId) {
        List<Vehicle> vehicles = vehicleRepository.findByClientId(clientId);
        if (vehicles.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehicles);
    }

    @Override
    public ResponseEntity<List<Vehicle>> getVehiclesByOrderStatus(String status) {
        List<Vehicle> vehicles = orderRepository.findDistinctByStatus(status);
        if (vehicles.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(vehicles);
    }

    @Override
    public ResponseEntity<Vehicle> updateVehicle(Long id, Vehicle vehicle) {
        if (!vehicleRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        vehicle.setId(id);
        return ResponseEntity.ok(vehicleRepository.save(vehicle));
    }

    @Override
    public ResponseEntity<Void> deleteVehicle(Long id) {
        if (!vehicleRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        vehicleRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}