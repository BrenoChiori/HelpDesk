package com.curso.helpdesk.services;

import com.curso.helpdesk.domain.Pessoa;
import com.curso.helpdesk.domain.Tecnico;
import com.curso.helpdesk.domain.dtos.TecnicoDTO;
import com.curso.helpdesk.repositories.PessoaRepository;
import com.curso.helpdesk.repositories.TecnicoRepository;
import com.curso.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.curso.helpdesk.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    public Tecnico findById(Integer id) {
        Optional<Tecnico> obj = tecnicoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id " + id));
    }

    public List<Tecnico> findAll() {
        return tecnicoRepository.findAll();
    }

    public Tecnico create(TecnicoDTO objDTO) {
        objDTO.setId(null);
        validaPorCpfEEMail(objDTO);
        Tecnico newObj = new Tecnico(objDTO);
        return tecnicoRepository.save(newObj);
    }

    private void validaPorCpfEEMail(TecnicoDTO objDTO) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
        if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema");
        }

        obj = pessoaRepository.findByEmail(objDTO.getEmail());
        if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
            throw new DataIntegrityViolationException("Email já cadastrado no sistema");
        }
    }
}
