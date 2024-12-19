package com.curso.helpdesk.resources;

import com.curso.helpdesk.domain.ProdutosPedidos;
import com.curso.helpdesk.domain.dtos.ProdutosPedidosDTO;
import com.curso.helpdesk.services.ProdutoService;
import com.curso.helpdesk.services.ProdutosPedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/produtospedidos")
public class ProdutosPedidosResource {

    @Autowired
    private ProdutosPedidosService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutosPedidosDTO> findById(@PathVariable Integer id){
        ProdutosPedidos obj = service.findById(id);
        return ResponseEntity.ok().body(new ProdutosPedidosDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<ProdutosPedidosDTO>> findAll() {
        List<ProdutosPedidos> list = service.findAll();
        List<ProdutosPedidosDTO> listDTO = list.stream().map(obj -> new ProdutosPedidosDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<ProdutosPedidosDTO> create(@Valid @RequestBody ProdutosPedidosDTO obj) {
        ProdutosPedidos newObj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProdutosPedidosDTO> update(@PathVariable Integer id, @Valid @RequestBody ProdutosPedidosDTO objDTO) {
        ProdutosPedidos newObj = service.update(id, objDTO);
        return ResponseEntity.ok(new ProdutosPedidosDTO(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ProdutosPedidosDTO> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
