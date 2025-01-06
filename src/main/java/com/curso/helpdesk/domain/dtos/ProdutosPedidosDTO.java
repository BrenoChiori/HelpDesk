package com.curso.helpdesk.domain.dtos;

import com.curso.helpdesk.domain.Fornecedor;
import com.curso.helpdesk.domain.Pedidos;
import com.curso.helpdesk.domain.Produto;
import com.curso.helpdesk.domain.ProdutosPedidos;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

public class ProdutosPedidosDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotNull(message = "O campo Produto e requerido")
    private Produto produto;
    @NotNull(message = "O campo Quantidade e requerido")
    private Integer quantidade;
    @NotNull(message = "O campo Fornecedor e requerido")
    private Fornecedor fornecedor;
    @NotNull(message = "O campo Pedidos e requerido")
    private Pedidos pedidos;
    @NotNull(message = "O campo Valor e requerido")
    private BigDecimal valor;

    public ProdutosPedidosDTO() {
        super();
    }

    public ProdutosPedidosDTO(ProdutosPedidos obj) {
        this.id = obj.getId();
        this.produto = obj.getProduto();
        this.quantidade = obj.getQuantidade();
        this.fornecedor = obj.getFornecedor();
        this.pedidos = obj.getPedidos();
        this.valor = obj.getValor();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }
}
