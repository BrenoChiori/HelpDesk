package com.curso.helpdesk.domain;

import java.io.Serializable;

public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Integer id;
    protected String descricao;

    public Pedido(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}