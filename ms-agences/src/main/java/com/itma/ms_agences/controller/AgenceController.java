package com.itma.ms_agences.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itma.ms_agences.dto.AgenceCreateDTO;
import com.itma.ms_agences.dto.AgenceReponseDTO;
import com.itma.ms_agences.model.Agence;
import com.itma.ms_agences.model.Banque;
import com.itma.ms_agences.services.AgenceService;
import com.itma.ms_agences.services.BanqueService;
@RestController
@RequestMapping("/ms-agences/agences/")


public class AgenceController {
	@Autowired
     private AgenceService agenceService;
	
	@PostMapping
	public AgenceReponseDTO create (@RequestBody AgenceCreateDTO agence) {
		return agenceService.createAgence(agence);
	}
	
	@GetMapping
	public List<AgenceReponseDTO> getAll(){
		return agenceService.findAll();
}
	@GetMapping("(id)")
	public Agence findById(@PathVariable(name="id")Long id) {
		return agenceService.getById(id);
	}

}

