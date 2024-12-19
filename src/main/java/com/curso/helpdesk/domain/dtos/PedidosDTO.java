package com.curso.helpdesk.domain.dtos;

import com.curso.helpdesk.domain.Pedidos;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PedidosDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPedido = LocalDate.now();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataEntrega;
    @NotNull(message = "O campo Status e requerido")
    private Integer status;
    @NotNull(message = "O campo Valor Total e requerido")
    private BigDecimal valorTotal;

    public PedidosDTO() {
        super();
    }

    public PedidosDTO(Pedidos obj) {
        this.id = obj.getId();
        this.dataPedido = obj.getDataPedido();
        this.dataEntrega = obj.getDataEntrega();
        this.status = obj.getStatus().getCodigo();
        this.valorTotal = obj.getValorTotal();
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
