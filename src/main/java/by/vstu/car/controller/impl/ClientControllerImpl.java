package by.vstu.car.controller.impl;

import by.vstu.car.controller.ClientController;
import by.vstu.car.model.Client;
import by.vstu.car.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientControllerImpl implements ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clientRepository.findAll());
    }

    @Override
    public ResponseEntity<Client> getClientById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Client> createClient(Client client) {
        return ResponseEntity.ok(clientRepository.save(client));
    }

    @Override
    public ResponseEntity<Client> updateClient(Long id, Client client) {
        if (!clientRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        client.setId(id);
        return ResponseEntity.ok(clientRepository.save(client));
    }

    @Override
    public ResponseEntity<Void> deleteClient(Long id) {
        if (!clientRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        clientRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}