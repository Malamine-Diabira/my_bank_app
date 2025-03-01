package com.itma.ms_agences.dto;

import org.springframework.beans.BeanUtils;

import com.itma.ms_agences.model.Adresse;
import com.itma.ms_agences.model.Agence;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AgenceCreateDTO {

	private String code;
	private String nom;
	private Adresse adresse;
	private Long banqueId;

	public AgenceCreateDTO(Agence agence) {

		BeanUtils.copyProperties(agence, this);
		banqueId = agence.getBanque().getId();

	}
}
