package com.cadernodecampo.springcadernodecampo.ConfigModel;

import com.cadernodecampo.springcadernodecampo.ServiceModel.DBService;

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
