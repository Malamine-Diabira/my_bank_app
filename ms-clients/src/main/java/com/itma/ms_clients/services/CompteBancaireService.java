package com.itma.ms_clients.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itma.ms_clients.exception.RessourceConflictException;
import com.itma.ms_clients.exception.RessourceNotFoundException;
import com.itma.ms_clients.model.CompteBancaire;
import com.itma.ms_clients.repository.CompteBancaireRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompteBancaireService {
    private final CompteBancaireRepository compteBancaireRepository;

    public CompteBancaire createCompte(CompteBancaire compte) {
        return compteBancaireRepository.save(compte);
    }

    public CompteBancaire getById(Long id) {
        return compteBancaireRepository.findById(id).orElseThrow(
                () -> new RessourceNotFoundException("Compte introuvable avec cet ID"));
    }

    public List<CompteBancaire> findAll() {
        return compteBancaireRepository.findAll();
    }

    public void deleteById(Long id) {
        if (!compteBancaireRepository.existsById(id)) {
            throw new RessourceConflictException("Ce compte n'existe pas");
        }
        compteBancaireRepository.deleteById(id);
    }

    public void deposer(Long id, float montant) {
        CompteBancaire compte = getById(id);
        compte.deposer(montant);
        compteBancaireRepository.save(compte);
    }

    public void retirer(Long id, float montant) {
        CompteBancaire compte = getById(id);
        compte.retirer(montant);
        compteBancaireRepository.save(compte);
    }

    public void virement(Long idSource, Long idDest, float montant) {
        CompteBancaire source = getById(idSource);
        CompteBancaire destination = getById(idDest);
        source.virer(destination, montant);
        compteBancaireRepository.save(source);
        compteBancaireRepository.save(destination);
    }
}
