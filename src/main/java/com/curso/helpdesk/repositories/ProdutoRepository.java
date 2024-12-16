package com.curso.helpdesk.repositories;

import com.curso.helpdesk.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
