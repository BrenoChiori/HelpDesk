package com.curso.helpdesk.domain.enums;

public enum FormadeEntrega {
    RETIRARLOJA("RETIRAR NA LOJA"), RETIRARPONTOCOLETA("RETIRAR NO PONTO DE COLETA") , ENTREGA("ENTREGA DOMICILIAR");

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
