package com.itma.ms_agences.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itma.ms_agences.model.Banque;
import com.itma.ms_agences.services.BanqueService;
@RestController
@RequestMapping("/ms-agences/banques/")


public class BanqueController {
	@Autowired
     private BanqueService banqueService;
	
	@PostMapping
	public Banque create (@RequestBody Banque banque) {
		return banqueService.create(banque);
	}
	
	@GetMapping
	public List<Banque> getAll(){
		return banqueService.findAll();
}
	@GetMapping("(id)")
	public Banque findById(@PathVariable(name="id")Long id) {
		return banqueService.getById(id);
	}
}

