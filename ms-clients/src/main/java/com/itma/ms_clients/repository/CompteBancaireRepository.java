package com.itma.ms_clients.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.itma.ms_clients.model.CompteBancaire;
import java.util.Optional;

@Repository
public interface CompteBancaireRepository extends JpaRepository<CompteBancaire, Long> {
    Optional<CompteBancaire> findByNumero(String numero);
}
