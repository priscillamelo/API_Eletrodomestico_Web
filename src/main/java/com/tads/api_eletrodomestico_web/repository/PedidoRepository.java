package com.tads.api_eletrodomestico_web.repository;

import com.tads.api_eletrodomestico_web.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
