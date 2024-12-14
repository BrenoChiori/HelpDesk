package com.curso.helpdesk.resources;

import com.curso.helpdesk.domain.Fornecedor;
import com.curso.helpdesk.domain.dtos.FornecedorDTO;
import com.curso.helpdesk.services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/fornecedor")
public class FornecedorResource {

    @Autowired
    private FornecedorService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<FornecedorDTO> findById(@PathVariable Integer id) {
        Fornecedor obj = service.findById(id);
        return ResponseEntity.ok().body(new FornecedorDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<FornecedorDTO>> findAll() {
        List<Fornecedor> list = service.findAll();
        List<FornecedorDTO> listDTO = list.stream().map(obj -> new FornecedorDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<FornecedorDTO> create(@Valid @RequestBody FornecedorDTO objDTO) {
        Fornecedor newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FornecedorDTO> update(@PathVariable Integer id, @Valid @RequestBody FornecedorDTO objDTO) {
        Fornecedor newObj = service.update(id, objDTO);
        return ResponseEntity.ok().body(new FornecedorDTO(newObj));
    }
}
