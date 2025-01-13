package com.curso.helpdesk.services;

import com.curso.helpdesk.domain.*;
import com.curso.helpdesk.domain.enums.*;
import com.curso.helpdesk.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class DBService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;
    @Autowired
    private FornecedorRepository fornecedorRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ProdutosPedidosRepository produtosPedidosRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private PedidosRepository pedidosRepository;

    public void instanciaDB() {
        Tecnico tec1 = new Tecnico(null, "Valdir Cezar", "550.482.150-95", "valdir@mail.com", encoder.encode("123"));
        tec1.addPerfil(Perfil.ADMIN);
        Tecnico tec2 = new Tecnico(null, "Richard Stallman", "903.347.070-56", "stallman@mail.com", encoder.encode("123"));
        Tecnico tec3 = new Tecnico(null, "Claude Elwood Shannon", "271.068.470-54", "shannon@mail.com", encoder.encode("123"));
        Tecnico tec4 = new Tecnico(null, "Tim Berners-Lee", "162.720.120-39", "lee@mail.com", encoder.encode("123"));
        Tecnico tec5 = new Tecnico(null, "Linus Torvalds", "778.556.170-27", "linus@mail.com", encoder.encode("123"));

        Cliente cli1 = new Cliente(null, "Albert Einstein", "111.661.890-74", "einstein@mail.com", encoder.encode("123"));
        Cliente cli2 = new Cliente(null, "Marie Curie", "322.429.140-06", "curie@mail.com", encoder.encode("123"));
        Cliente cli3 = new Cliente(null, "Charles Darwin", "792.043.830-62", "darwin@mail.com", encoder.encode("123"));
        Cliente cli4 = new Cliente(null, "Stephen Hawking", "177.409.680-30", "hawking@mail.com", encoder.encode("123"));
        Cliente cli5 = new Cliente(null, "Max Planck", "081.399.300-83", "planck@mail.com", encoder.encode("123"));

        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 1", "Teste chamado 1", tec1, cli1);
        Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 2", "Teste chamado 2", tec1, cli2);
        Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 3", "Teste chamado 3", tec2, cli3);
        Chamado c4 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 4", "Teste chamado 4", tec3, cli3);
        Chamado c5 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 5", "Teste chamado 5", tec2, cli1);
        Chamado c6 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 7", "Teste chamado 6", tec1, cli5);

        Fornecedor f1 = new Fornecedor(null, "Fornecedor Exemplo", TipoFornecedor.CNPJ, "12345678000123", "11999999999", "fornecedor@exemplo.com", new Endereco("Rua Exemplo", "123", "Sala 101", "Bairro Exemplo", "Cidade Exemplo", "SP", "12345-678") , StatusFornecedor.DESATIVADO, FormadeEntrega.ENTREGA);
        Fornecedor f2 = new Fornecedor(null, "João da Silva", TipoFornecedor.CPF, "12345678900", "11988887777", "joao@exemplo.com", new Endereco("Rua Sem Nome", "45", "", "Vila Alegre", "São Paulo", "SP", "05400-000") , StatusFornecedor.ATIVO, FormadeEntrega.RETIRARPONTOCOLETA);
        Fornecedor f3 = new Fornecedor(null, "Empresa Teste LTDA", TipoFornecedor.CNPJ, "98765432000122", "1133334444", "contato@empresateste.com", new Endereco("Avenida das Empresas", "500", "Bloco A", "Centro", "Rio de Janeiro", "RJ", "20000-000") , StatusFornecedor.ATIVO, FormadeEntrega.RETIRARLOJA);

        Produto p1 = new Produto(null, "HP", "Tinta para Impressora 664");
        Produto p2 = new Produto(null, "Kingston", "Memória RAM 8GB DDR4");
        Produto p3 = new Produto(null, "Dell", "Notebook Inspiron 15 3000");
        Produto p4 = new Produto(null, "Logitech", "Mouse Sem Fio M170");
        Produto p5 = new Produto(null, "Acer", "Notebook Aspire 5");
        Produto p6 = new Produto(null, "Brother", "Impressora Laser HL1212W");
        Produto p7 = new Produto(null, "TP-Link", "Roteador Wi-Fi Archer C6");
        Produto p8 = new Produto(null, "Seagate", "HD Externo 1TB");
        Produto p9 = new Produto(null, "Samsung", "SSD 980 NVMe 500GB");
        Produto p10 = new Produto(null, "Positivo", "Notebook Motion C");
        Produto p11 = new Produto(null, "Epson", "Tinta para Impressora EcoTank L3250");
        Produto p12 = new Produto(null, "HyperX", "Teclado Mecânico Alloy Origins");
        Produto p13 = new Produto(null, "LG", "Monitor Ultrawide 29");
        Produto p14 = new Produto(null, "Sony", "Headset Bluetooth WH-1000XM4");
        Produto p15 = new Produto(null, "Corsair", "Fonte 650W 80 Plus Bronze");

        pessoaRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, cli1, cli2, cli3, cli4, cli5));
        chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
        fornecedorRepository.saveAll(Arrays.asList(f1, f2, f3));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15));
    }
}
