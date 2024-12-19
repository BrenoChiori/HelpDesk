package com.curso.helpdesk.services;

import com.curso.helpdesk.domain.Pedidos;
import com.curso.helpdesk.domain.dtos.PedidosDTO;
import com.curso.helpdesk.domain.enums.Status;
import com.curso.helpdesk.repositories.PedidosRepository;
import com.curso.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository repository;

    public Pedidos findById(Integer id) {
        Optional<Pedidos> pedido = repository.findById(id);
        return pedido.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
    }

    public List<Pedidos> findAll() {
        return repository.findAll();
    }

    public Pedidos create(PedidosDTO objDTO) {
        return repository.save(newPedido(objDTO));
    }

    public Pedidos update(Integer id, @Valid PedidosDTO objDTO) {
        objDTO.setId(id);
        Pedidos oldObj = findById(id);
        oldObj = newPedido(objDTO);
        return repository.save(oldObj);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    private Pedidos newPedido(PedidosDTO obj) {
        Pedidos pedido = new Pedidos();
        if(obj.getId() != null) {
            pedido.setId(obj.getId());
        }

        if(obj.getStatus().equals(2)){
            pedido.setDataEntrega(LocalDate.now());
        }

        pedido.setDataPedido(obj.getDataPedido());
        pedido.setDataEntrega(obj.getDataEntrega());
        pedido.setStatus(Status.toEnum(obj.getStatus()));
        pedido.setValorTotal(obj.getValorTotal());
        return pedido;
    }
}
