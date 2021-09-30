package com.cadernodecampo.springcadernodecampo.ConfigModule;

import com.cadernodecampo.springcadernodecampo.ServiceModule.DBService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
    @Autowired
    private DBService dbService;

    @Bean
    public void istanciaBaseDeDados(){
        this.dbService.InstanciaBaseDeDados();
    }
}
