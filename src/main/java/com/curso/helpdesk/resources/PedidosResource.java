package com.curso.helpdesk.resources;

import com.curso.helpdesk.domain.Pedidos;
import com.curso.helpdesk.domain.dtos.PedidosDTO;
import com.curso.helpdesk.services.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidosResource {

    @Autowired
    private PedidosService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PedidosDTO> findById(@PathVariable Integer id) {
        Pedidos obj = service.findById(id);
        return ResponseEntity.ok().body(new PedidosDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<PedidosDTO>> findAll() {
        List<Pedidos> list = service.findAll();
        List<PedidosDTO> listDTO = list.stream().map(obj -> new PedidosDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok(listDTO);
    }

    @PostMapping
    public ResponseEntity<PedidosDTO> create(@Valid @RequestBody PedidosDTO objDto) {
        Pedidos newObj = service.create(objDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PedidosDTO> update(@PathVariable Integer id, @Valid @RequestBody PedidosDTO objDTO) {
        Pedidos newObj = service.update(id, objDTO);
        return ResponseEntity.ok(new PedidosDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PedidosDTO> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
