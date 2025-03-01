package com.itma.ms_clients.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.itma.ms_clients.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

    boolean existsByCode(String code);
}
