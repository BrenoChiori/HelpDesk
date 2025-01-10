package com.curso.helpdesk.domain;

import com.curso.helpdesk.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPedido = LocalDate.now();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEntrega;
    private Status status;
    private BigDecimal valorTotal;

    @JsonManagedReference
    @OneToMany(mappedBy= "pedidos", cascade = CascadeType.ALL)
    private List<ProdutosPedidos> listaProdutos = new ArrayList<>();

    public Pedidos() {
        super();
    }

    public Pedidos(Integer id, Status status, BigDecimal valorTotal) {
        this.id = id;
        this.status = status;
        this.valorTotal = valorTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ProdutosPedidos> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<ProdutosPedidos> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedidos pedidos = (Pedidos) o;
        return Objects.equals(id, pedidos.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
