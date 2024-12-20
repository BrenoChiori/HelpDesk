package com.curso.helpdesk.services;

import com.curso.helpdesk.domain.Fornecedor;
import com.curso.helpdesk.domain.dtos.FornecedorDTO;
import com.curso.helpdesk.repositories.FornecedorRepository;
import com.curso.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public Fornecedor findById(Integer id) {
        Optional<Fornecedor> fornecedor = repository.findById(id);
        return fornecedor.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
    }

    public List<Fornecedor> findAll() {
        return repository.findAll();
    }

    public Fornecedor create(FornecedorDTO obj) {
        return repository.save(newFornecedor(obj));
    }

    public Fornecedor update(Integer id, @Valid FornecedorDTO objDTO) {
        objDTO.setId(id);
        Fornecedor oldObj = newFornecedor(objDTO);
        return repository.save(oldObj);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Fornecedor newFornecedor(FornecedorDTO obj) {
        Fornecedor fornecedor = new Fornecedor();
        
        if (obj.getId() != null) {
            fornecedor.setId(obj.getId());
        }
        
        fornecedor.setNome(obj.getNome());
        fornecedor.setEmail(obj.getEmail());
        fornecedor.setTelefone(obj.getTelefone());
        fornecedor.setEmail(obj.getEmail());
        fornecedor.setDocumento(obj.getDocumento());
        fornecedor.setTipoFornecedor(obj.getTipoFornecedor());
        fornecedor.setEndereco(obj.getEndereco());
        fornecedor.setStatusFornecedor(obj.getStatusFornecedor());
        fornecedor.setFormadeEntrega(obj.getFormadeEntrega());
        return fornecedor;
    }
}