package com.itma.ms_clients.services;

import org.springframework.stereotype.Service;

import com.itma.ms_clients.exception.RessourceNotFoundException;
import com.itma.ms_clients.model.CompteEpargne;
import com.itma.ms_clients.repository.CompteEpargneRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompteEpargneService {
    private final CompteEpargneRepository compteEpargneRepository;

    public CompteEpargne createCompte(CompteEpargne compte) {
        return compteEpargneRepository.save(compte);
    }

    public CompteEpargne getById(Long id) {
        return compteEpargneRepository.findById(id).orElseThrow(
                () -> new RessourceNotFoundException("Compte épargne introuvable avec cet ID"));
    }

    public void setTauxInteret(Long id, float taux) {
        CompteEpargne compte = getById(id);
        compte.setTauxInteret(taux);
        compteEpargneRepository.save(compte);
    }
}
