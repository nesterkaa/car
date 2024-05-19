package by.vstu.car.controller;


import by.vstu.car.model.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/clients")
public interface ClientController {

    @GetMapping
    ResponseEntity<List<Client>> getAllClients();

    @GetMapping("/{id}")
    ResponseEntity<Client> getClientById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<Client> createClient(@RequestBody Client client);

    @PutMapping("/{id}")
    ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteClient(@PathVariable Long id);
}
