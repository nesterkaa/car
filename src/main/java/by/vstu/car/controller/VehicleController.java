package by.vstu.car.controller;

import by.vstu.car.model.Vehicle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/vehicles")
public interface VehicleController {

    @GetMapping
    ResponseEntity<List<Vehicle>> getAllVehicles();

    @GetMapping("/{id}")
    ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id);

    @GetMapping("/client/{clientId}")
    ResponseEntity<List<Vehicle>> getVehiclesByClientId(@PathVariable Long clientId);

    @GetMapping("/status/{status}")
    ResponseEntity<List<Vehicle>> getVehiclesByOrderStatus(@PathVariable String status);

    @PostMapping
    ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle);

    @PutMapping("/{id}")
    ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteVehicle(@PathVariable Long id);
}