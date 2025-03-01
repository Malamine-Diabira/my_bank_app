package com.itma.ms_clients.services;

import org.springframework.stereotype.Service;

import com.itma.ms_clients.exception.RessourceNotFoundException;
import com.itma.ms_clients.model.CompteCourant;
import com.itma.ms_clients.repository.CompteCourantRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompteCourantService {
    private final CompteCourantRepository compteCourantRepository;

    public CompteCourant createCompte(CompteCourant compte) {
        return compteCourantRepository.save(compte);
    }

    public CompteCourant getById(Long id) {
        return compteCourantRepository.findById(id).orElseThrow(
                () -> new RessourceNotFoundException("Compte courant introuvable avec cet ID"));
    }

    public void setDecouvert(Long id, float montant) {
        CompteCourant compte = getById(id);
        compte.setDecouvertAutorise(montant);
        compteCourantRepository.save(compte);
    }
}
