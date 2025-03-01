package com.itma.ms_agences.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itma.ms_agences.dto.AgenceCreateDTO;
import com.itma.ms_agences.dto.AgenceReponseDTO;
import com.itma.ms_agences.exception.RessourceConflictException;
import com.itma.ms_agences.exception.RessourceNotFowndException;
import com.itma.ms_agences.mapper.MyMapper;
import com.itma.ms_agences.model.Agence;
import com.itma.ms_agences.repository.AgenceRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AgenceService {
	private AgenceRepository agenceRepository;
	private MyMapper myMapper;

	public AgenceReponseDTO createAgence(AgenceCreateDTO agenceDTO) {
		if (agenceRepository.existsByCode(agenceDTO.getCode()))
			throw new RessourceConflictException("Ce code existe déjà");

		Agence agence = myMapper.AgenceCreateDtoToAgence(agenceDTO);
		agence = agenceRepository.save(agence);
		return new AgenceReponseDTO(agence);

	}

	public Agence getById(Long id) {
		return agenceRepository.findById(id)
				.orElseThrow(() -> new RessourceNotFowndException("Cet Id est introuvable"));
	}

	public List<AgenceReponseDTO> findAll(){
		
		List<Agence> agences=agenceRepository.findAll();
		List<AgenceReponseDTO> agencesDTO=agences
				.stream()
				.map(AgenceReponseDTO::new).toList();
		return agencesDTO;
		
	}

	public void delete(Long id) {
		agenceRepository.deleteById(id);
	}
}
