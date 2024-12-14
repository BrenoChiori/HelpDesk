package com.curso.helpdesk.domain.enums;

public enum StatusFornecedor {
    ATIVO("ATIVO"), DESATIVADO("DESATIVADO");

    private String descricao;

    StatusFornecedor(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
