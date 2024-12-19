package com.curso.helpdesk.domain.dtos;

import com.curso.helpdesk.domain.ProdutosPedidos;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

public class ProdutosPedidosDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotNull(message = "O campo Produto e requerido")
    private Integer produto;
    @NotNull(message = "O campo Quantidade e requerido")
    private Integer quantidade;
    @NotNull(message = "O campo Fornecedor e requerido")
    private Integer fornecedor;
    @NotNull(message = "O campo Pedidos e requerido")
    private Integer pedidos;
    @NotNull(message = "O campo Valor e requerido")
    private BigDecimal valor;

    public ProdutosPedidosDTO() {
        super();
    }

    public ProdutosPedidosDTO(ProdutosPedidos obj) {
        this.id = obj.getId();
        this.produto = obj.getProduto().getId();
        this.quantidade = obj.getQuantidade();
        this.fornecedor = obj.getFornecedor().getId();
        this.pedidos = obj.getPedidos().getId();
        this.valor = obj.getValor();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProduto() {
        return produto;
    }

    public void setProduto(Integer produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Integer fornecedor) {
        this.fornecedor = fornecedor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getPedidos() {
        return pedidos;
    }

    public void setPedidos(Integer pedidos) {
        this.pedidos = pedidos;
    }
}
