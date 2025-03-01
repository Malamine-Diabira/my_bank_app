package com.itma.ms_clients.model;



import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) 
@Data
public abstract class CompteBancaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String numero;
    private float solde;
    private LocalDate dateOuverture;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


    public void deposer(float montant) {
        this.solde += montant;
    }

    public void retirer(float montant) {
        if (this.solde >= montant) {
            this.solde -= montant;
        } else {
            throw new RuntimeException("Solde insuffisant !");
        }
    }

    public void virer(CompteBancaire compteDestinataire, float montant) {
        this.retirer(montant);
        compteDestinataire.deposer(montant);
    }
}

