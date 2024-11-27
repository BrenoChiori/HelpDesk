package com.curso.helpdesk.config;

import com.curso.helpdesk.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TesteConfig {

    @Autowired
    private DBService dbService;

    @Bean
    Boolean instanciaDb() {
        this.dbService.instanciaDB();
        return true;
    }
}
