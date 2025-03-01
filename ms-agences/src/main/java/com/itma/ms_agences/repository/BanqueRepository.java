package com.itma.ms_agences.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itma.ms_agences.model.Banque;

public interface BanqueRepository extends JpaRepository<Banque, Long>{

	boolean existsByCode(String code);

	
}


