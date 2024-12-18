package com.curso.helpdesk.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String marca;
    private String nomeProduto;
    @ManyToOne
    private Fornecedor fornecedor;

    public Produto() {
        super();
    }

    public Produto(Integer id, String marca, String nomeProduto, Fornecedor fornecedor) {
        this.id = id;
        this.marca = marca;
        this.nomeProduto = nomeProduto;
        this.fornecedor = fornecedor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}