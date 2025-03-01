package com.itma.ms_agences.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.itma.ms_agences.dto.AgenceCreateDTO;
import com.itma.ms_agences.exception.RessourceNotFowndException;
import com.itma.ms_agences.model.Agence;
import com.itma.ms_agences.model.Banque;
import com.itma.ms_agences.repository.BanqueRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class MyMapper {
    private BanqueRepository banqueRepository;
    
    public Agence AgenceCreateDtoToAgence(AgenceCreateDTO dto)
    {
    	Agence agence =new Agence();
    	BeanUtils.copyProperties(dto, agence);
    	Banque banque=banqueRepository.findById(dto.getBanqueId())
    			.orElseThrow(()->new RessourceNotFowndException("Aucune banque trouvée"));
    	
    		agence.setBanque(banque);
		return agence;
    }
}
