package com.curso.helpdesk.domain.enums;

public enum FormadeEntrega {
    PRESENCIAL("PRESENCIAL"), ENTREGA("ENTREGA");

    private String descricao;

    FormadeEntrega(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
