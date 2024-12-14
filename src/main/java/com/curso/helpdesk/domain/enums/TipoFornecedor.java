package com.curso.helpdesk.domain.enums;

public enum TipoFornecedor {
    CPF("CPF"), CNPJ("CNPJ");

    private String descricao;

    TipoFornecedor(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
