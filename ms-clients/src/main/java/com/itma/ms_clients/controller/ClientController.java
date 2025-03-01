package com.itma.ms_clients.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.itma.ms_clients.model.Client;
import com.itma.ms_clients.services.ClientService;

@RestController
@RequestMapping("/ms-banque/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    public Client create(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @GetMapping
    public List<Client> getAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable Long id) {
        return clientService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteById(id);
    }
}
