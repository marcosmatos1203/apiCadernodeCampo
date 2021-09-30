package com.cadernodecampo.springcadernodecampo.ConfigModule;

import com.cadernodecampo.springcadernodecampo.ServiceModule.DBService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("postgre")
public class PostgreConfig {
    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean instanciaBaseDeDados(){
        if(strategy.equals("create")){
            this.dbService.InstanciaBaseDeDados();
        }
        return false;
    }
}
