package com.itma.ms_clients.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class CompteEpargne extends CompteBancaire {
    private float tauxInteret;
}
