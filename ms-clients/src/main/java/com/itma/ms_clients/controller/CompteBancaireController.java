package com.itma.ms_clients.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.itma.ms_clients.model.CompteBancaire;
import com.itma.ms_clients.services.CompteBancaireService;

@RestController
@RequestMapping("/ms-banque/comptes")
public class CompteBancaireController {
    @Autowired
    private CompteBancaireService compteBancaireService;

    @PostMapping
    public CompteBancaire create(@RequestBody CompteBancaire compte) {
        return compteBancaireService.createCompte(compte);
    }

    @GetMapping
    public List<CompteBancaire> getAll() {
        return compteBancaireService.findAll();
    }

    @GetMapping("/{id}")
    public CompteBancaire findById(@PathVariable Long id) {
        return compteBancaireService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCompte(@PathVariable Long id) {
        compteBancaireService.deleteById(id);
    }

    @PostMapping("/{id}/depot/{montant}")
    public void deposer(@PathVariable Long id, @PathVariable float montant) {
        compteBancaireService.deposer(id, montant);
    }

    @PostMapping("/{id}/retrait/{montant}")
    public void retirer(@PathVariable Long id, @PathVariable float montant) {
        compteBancaireService.retirer(id, montant);
    }

    @PostMapping("/{idSource}/virement/{idDest}/{montant}")
    public void virement(@PathVariable Long idSource, @PathVariable Long idDest, @PathVariable float montant) {
        compteBancaireService.virement(idSource, idDest, montant);
    }
}
