package com.itma.ms_agences.services;

import java.security.PublicKey;
import java.util.List;

import org.springframework.stereotype.Service;

import com.itma.ms_agences.exception.RessourceConflictException;
import com.itma.ms_agences.exception.RessourceNotFowndException;
import com.itma.ms_agences.model.Banque;
import com.itma.ms_agences.repository.BanqueRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BanqueService {
	private BanqueRepository banqueRepository;

	public Banque create(Banque banque) {
		if (banqueRepository.existsByCode(banque.getCode()))
			throw new RessourceConflictException("Ce code existe déjà");
		
		return banqueRepository.save(banque);

	}

	public Banque getById(Long id) {
		  	return banqueRepository.findById(id).orElseThrow(()->new RessourceNotFowndException("Cet Id est introuvable"));
	}
	
	public List<Banque> findAll(){
		return banqueRepository.findAll(); 
	}

}
