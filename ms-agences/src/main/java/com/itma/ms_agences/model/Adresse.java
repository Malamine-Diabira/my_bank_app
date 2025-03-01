package com.itma.ms_agences.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Adresse {
  private String ville;
  private String quartier;
  private String rue;
  
  
	

}
