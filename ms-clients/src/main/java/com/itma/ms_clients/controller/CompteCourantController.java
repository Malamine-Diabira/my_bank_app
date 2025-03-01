package com.itma.ms_clients.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.itma.ms_clients.model.CompteCourant;
import com.itma.ms_clients.services.CompteCourantService;

@RestController
@RequestMapping("/ms-banque/comptes-courants")
public class CompteCourantController {
    @Autowired
    private CompteCourantService compteCourantService;

    @PostMapping
    public CompteCourant create(@RequestBody CompteCourant compte) {
        return compteCourantService.createCompte(compte);
    }

    @GetMapping("/{id}")
    public CompteCourant findById(@PathVariable Long id) {
        return compteCourantService.getById(id);
    }

    @PostMapping("/{id}/decouvert/{montant}")
    public void setDecouvert(@PathVariable Long id, @PathVariable float montant) {
        compteCourantService.setDecouvert(id, montant);
    }
}
