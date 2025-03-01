package com.itma.ms_clients.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.itma.ms_clients.exception.RessourceConflictException;
import com.itma.ms_clients.exception.RessourceNotFoundException;
import com.itma.ms_clients.model.Client;
import com.itma.ms_clients.repository.ClientRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client getById(Long id) {
        return clientRepository.findById(id).orElseThrow(
                () -> new RessourceNotFoundException("Client introuvable avec cet ID"));
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public void deleteById(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new RessourceConflictException("Ce client n'existe pas");
        }
        clientRepository.deleteById(id);
    }
}
