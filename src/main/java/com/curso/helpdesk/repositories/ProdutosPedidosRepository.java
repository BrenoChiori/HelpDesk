package com.curso.helpdesk.repositories;

import com.curso.helpdesk.domain.ProdutosPedidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosPedidosRepository extends JpaRepository<ProdutosPedidos, Integer> {
}
