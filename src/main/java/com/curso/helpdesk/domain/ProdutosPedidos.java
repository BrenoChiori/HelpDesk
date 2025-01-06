package com.curso.helpdesk.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ProdutosPedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produtos_id")
    private Produto produto;
    private Integer quantidade;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pedidos_id")
    private Pedidos pedidos;
    private BigDecimal valor;

    public ProdutosPedidos() {
        super();
    }

    public ProdutosPedidos(Integer id, Produto produto, Integer quantidade, Fornecedor fornecedor, Pedidos pedidos, BigDecimal valor) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
        this.pedidos = pedidos;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
