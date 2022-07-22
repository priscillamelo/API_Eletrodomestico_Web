package com.tads.api_eletrodomestico_web.repository;

import com.tads.api_eletrodomestico_web.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
