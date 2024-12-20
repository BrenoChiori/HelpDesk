package com.curso.helpdesk.services;

import com.curso.helpdesk.domain.Fornecedor;
import com.curso.helpdesk.domain.Pedidos;
import com.curso.helpdesk.domain.Produto;
import com.curso.helpdesk.domain.ProdutosPedidos;
import com.curso.helpdesk.domain.dtos.ProdutosPedidosDTO;
import com.curso.helpdesk.repositories.ProdutosPedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutosPedidosService {

    @Autowired
    private ProdutosPedidosRepository repository;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private FornecedorService fornecedorService;
    @Autowired
    private PedidosService pedidosService;

    public ProdutosPedidos findById(Integer id) {
        Optional<ProdutosPedidos> produtosPedidos = repository.findById(id);
        return produtosPedidos.orElseThrow(() -> new RuntimeException("Objeto não encontrado! Id: " + id));
    }

    public List<ProdutosPedidos> findAll() {
        return repository.findAll();
    }

    public ProdutosPedidos create(ProdutosPedidosDTO obj) {
        return repository.save(newProdutosPedidos(obj));
    }

    public ProdutosPedidos update(Integer id, @Valid ProdutosPedidosDTO objDTO) {
        objDTO.setId(id);
        ProdutosPedidos oldObj = newProdutosPedidos(objDTO);
        return repository.save(oldObj);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    private ProdutosPedidos newProdutosPedidos(ProdutosPedidosDTO obj) {
        Produto produto = produtoService.findById(obj.getProduto());
        Fornecedor fornecedor = fornecedorService.findById(obj.getFornecedor());
        Pedidos pedidos = pedidosService.findById(obj.getPedidos());

        ProdutosPedidos produtosPedidos = new ProdutosPedidos();
        if(obj.getId() != null) {
            produtosPedidos.setId(obj.getId());
        }

        produtosPedidos.setProduto(produto);
        produtosPedidos.setQuantidade(obj.getQuantidade());
        produtosPedidos.setFornecedor(fornecedor);
        produtosPedidos.setPedidos(pedidos);
        produtosPedidos.setValor(obj.getValor());
        return produtosPedidos;
    }
}
