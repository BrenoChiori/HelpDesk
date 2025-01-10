package com.curso.helpdesk.services;

import com.curso.helpdesk.domain.Pedidos;
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

    public Pedidos create(Pedidos obj) {
        return repository.save(obj);
    }

    public Pedidos update(Integer id, @Valid Pedidos obj) {
        Pedidos oldObj = findById(id);
        updatePedido(oldObj, obj);
        return repository.save(oldObj);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    private void updatePedido(Pedidos oldObj, Pedidos obj) {
        oldObj.setDataPedido(obj.getDataPedido());
        oldObj.setStatus(obj.getStatus());
        oldObj.setValorTotal(obj.getValorTotal());
        oldObj.setListaProdutos(obj.getListaProdutos());
    }
}
