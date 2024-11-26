package com.curso.helpdesk.services;

import com.curso.helpdesk.domain.Chamado;
import com.curso.helpdesk.domain.Cliente;
import com.curso.helpdesk.domain.Tecnico;
import com.curso.helpdesk.domain.enums.Perfil;
import com.curso.helpdesk.domain.enums.Prioridade;
import com.curso.helpdesk.domain.enums.Status;
import com.curso.helpdesk.repositories.ChamadoRepository;
import com.curso.helpdesk.repositories.ClienteRepository;
import com.curso.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;

    public void instanciaDB() {
        Tecnico tec1 = new Tecnico(null, "Valdir Cezar", "67027254930","valdir@email.com", "123");
        tec1.addPerfil(Perfil.ADMIN);

        Cliente cli1 = new Cliente(null, "Linus Torvalds", "57510844622", "torvalds@email.com", "123");

        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);

        tecnicoRepository.saveAll(Arrays.asList(tec1));
        clienteRepository.saveAll(Arrays.asList(cli1));
        chamadoRepository.saveAll(Arrays.asList(c1));
    }
}
