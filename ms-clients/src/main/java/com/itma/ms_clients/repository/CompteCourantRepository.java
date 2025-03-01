package com.itma.ms_clients.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.itma.ms_clients.model.CompteCourant;

@Repository
public interface CompteCourantRepository extends JpaRepository<CompteCourant, Long> {
}
