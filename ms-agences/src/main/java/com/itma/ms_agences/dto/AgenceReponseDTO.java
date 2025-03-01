package com.itma.ms_agences.dto;

import org.springframework.beans.BeanUtils;

import com.itma.ms_agences.model.Adresse;
import com.itma.ms_agences.model.Agence;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AgenceReponseDTO {
	private Long id;
	private String code;
	private String nom;
	private Adresse adresse;
	private Long banqueId;

	public AgenceReponseDTO(Agence agence) {

		BeanUtils.copyProperties(agence, this);
		this.banqueId = agence.getBanque().getId();

	}
}
