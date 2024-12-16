package com.curso.helpdesk.domain.dtos;

import com.curso.helpdesk.domain.Endereco;
import com.curso.helpdesk.domain.Fornecedor;
import com.curso.helpdesk.domain.enums.FormadeEntrega;
import com.curso.helpdesk.domain.enums.StatusFornecedor;
import com.curso.helpdesk.domain.enums.TipoFornecedor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class FornecedorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotNull(message = "O campo Nome e requerido")
    private String nome;
    @NotNull(message = "O campo Email e requerido")
    private String email;
    @NotNull(message = "O campo Telefone e requerido")
    private String telefone;
    @NotNull(message = "O campo Documento e requerido")
    private String documento;
    @NotNull(message = "O campo CPF/CNPJ e requerido")
    private TipoFornecedor tipoFornecedor;
    @NotNull(message = "O campo Endereço e requerido")
    private Endereco endereco;
    @NotNull(message = "O campo Status e requerido")
    private StatusFornecedor statusFornecedor;
    @NotNull(message = "O campo Entrega e requerido")
    private FormadeEntrega formadeEntrega;

    public FornecedorDTO() {
        super();
    }

    public FornecedorDTO(Fornecedor obj) {
        this.id = obj.getId();
        this.formadeEntrega = obj.getFormadeEntrega();
        this.statusFornecedor = obj.getStatusFornecedor();
        this.endereco = obj.getEndereco();
        this.tipoFornecedor = obj.getTipoFornecedor();
        this.documento = obj.getDocumento();
        this.telefone = obj.getTelefone();
        this.email = obj.getEmail();
        this.nome = obj.getNome();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public TipoFornecedor getTipoFornecedor() {
        return tipoFornecedor;
    }

    public void setTipoFornecedor(TipoFornecedor tipoFornecedor) {
        this.tipoFornecedor = tipoFornecedor;
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

    public FormadeEntrega getFormadeEntrega() {
        return formadeEntrega;
    }

    public void setFormadeEntrega(FormadeEntrega formadeEntrega) {
        this.formadeEntrega = formadeEntrega;
    }
}
