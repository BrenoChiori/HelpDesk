package com.curso.helpdesk.domain.dtos;

import com.curso.helpdesk.domain.Produto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ProdutoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotNull(message = "O campo Marca e requerido")
    private String marca;
    @NotNull(message = "O campo Nome Produto e requerido")
    private String nomeProduto;

    public ProdutoDTO() {
        super();
    }

    public ProdutoDTO(Produto obj) {
        this.id = obj.getId();
        this.marca = obj.getMarca();
        this.nomeProduto = obj.getNomeProduto();
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
}
