package com.curso.helpdesk.repositories;

import com.curso.helpdesk.domain.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {
}
