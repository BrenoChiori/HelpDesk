package com.curso.helpdesk.services;

import com.curso.helpdesk.domain.Produto;
import com.curso.helpdesk.domain.dtos.ProdutoDTO;
import com.curso.helpdesk.repositories.ProdutoRepository;
import com.curso.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto findById(Integer id) {
        Optional<Produto> produto = repository.findById(id);
        return produto.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
    }

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public Produto create(ProdutoDTO obj) {
        return repository.save(newProduto(obj));
    }

    public Produto update(Integer id, @Valid ProdutoDTO objDTO) {
        objDTO.setId(id);
        Produto oldObj = newProduto(objDTO);
        return repository.save(oldObj);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Produto newProduto(ProdutoDTO obj) {
        Produto produto = new Produto();

        if(obj.getId() != null) {
            produto.setId(obj.getId());
        }

        produto.setMarca(obj.getMarca());
        produto.setNomeProduto(obj.getNomeProduto());
        return produto;
    }
}
