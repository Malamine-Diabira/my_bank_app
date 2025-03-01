package com.itma.ms_clients.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.itma.ms_clients.model.CompteEpargne;
import com.itma.ms_clients.services.CompteEpargneService;

@RestController
@RequestMapping("/ms-banque/comptes-epargne")
public class CompteEpargneController {
    @Autowired
    private CompteEpargneService compteEpargneService;

    @PostMapping
    public CompteEpargne create(@RequestBody CompteEpargne compte) {
        return compteEpargneService.createCompte(compte);
    }

    @GetMapping("/{id}")
    public CompteEpargne findById(@PathVariable Long id) {
        return compteEpargneService.getById(id);
    }

    @PostMapping("/{id}/taux/{taux}")
    public void setTauxInteret(@PathVariable Long id, @PathVariable float taux) {
        compteEpargneService.setTauxInteret(id, taux);
    }
}
