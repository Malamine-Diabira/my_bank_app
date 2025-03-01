package com.itma.ms_clients.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nom;
    private String code;
    private String prenom;
    private String telephone;
    private String adresse;
    private String genre;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<CompteBancaire> comptes;
}
