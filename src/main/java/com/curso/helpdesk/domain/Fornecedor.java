package com.curso.helpdesk.domain;

import com.curso.helpdesk.domain.enums.FormadeEntrega;
import com.curso.helpdesk.domain.enums.StatusFornecedor;
import com.curso.helpdesk.domain.enums.TipoFornecedor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Fornecedor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private TipoFornecedor tipoFornecedor;
    private String documento;
    private String telefone;
    private String email;
    @Embedded
    private Endereco endereco;
    @Enumerated(EnumType.STRING)
    private StatusFornecedor statusFornecedor;
    @Enumerated(EnumType.STRING)
    private FormadeEntrega formadeEntrega;

    public Fornecedor() {
        super();
    }

    public Fornecedor(Integer id, String nome, TipoFornecedor tipoFornecedor, String documento, String telefone, String email, Endereco endereco, StatusFornecedor statusFornecedor, FormadeEntrega formadeEntrega) {
        this.id = id;
        this.nome = nome;
        this.tipoFornecedor = tipoFornecedor;
        this.documento = documento;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.statusFornecedor = statusFornecedor;
        this.formadeEntrega = formadeEntrega;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoFornecedor getTipoFornecedor() {
        return tipoFornecedor;
    }

    public void setTipoFornecedor(TipoFornecedor tipoFornecedor) {
        this.tipoFornecedor = tipoFornecedor;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public StatusFornecedor getStatusFornecedor() {
        return statusFornecedor;
    }

    public void setStatusFornecedor(StatusFornecedor statusFornecedor) {
        this.statusFornecedor = statusFornecedor;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public FormadeEntrega getFormadeEntrega() {
        return formadeEntrega;
    }

    public void setFormadeEntrega(FormadeEntrega formadeEntrega) {
        this.formadeEntrega = formadeEntrega;
    }
}
