package com.curso.helpdesk.repositories;

import com.curso.helpdesk.domain.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosRepository extends JpaRepository<Pedidos, Integer> {
}
