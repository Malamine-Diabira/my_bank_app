package com.itma.ms_agences.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itma.ms_agences.model.Agence;

public interface AgenceRepository extends JpaRepository<Agence,Long>{

	boolean existsByCode(String code);
	

}
