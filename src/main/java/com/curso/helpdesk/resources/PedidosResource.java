package com.curso.helpdesk.resources;

import com.curso.helpdesk.domain.Pedidos;
import com.curso.helpdesk.services.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidosResource {

    @Autowired
    private PedidosService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedidos> findById(@PathVariable Integer id) {
        Pedidos obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Pedidos>> findAll() {
        List<Pedidos> list = service.findAll();
//        List<PedidosDTO> listDTO = list.stream().map(obj -> new PedidosDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<Pedidos> create(@RequestBody Pedidos obj) {
        Pedidos newObj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Pedidos> update(@PathVariable Integer id, @Valid @RequestBody Pedidos obj) {
        service.update(id, obj);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Pedidos> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}