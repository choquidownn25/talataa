package org.example.configuration;

import org.example.adapters.SalaJpaAdapter;
import org.exemple.ports.api.SalaServicePort;
import org.exemple.ports.spi.SalaPersistencePort;
import org.exemple.service.SalaServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalaConfig {
    @Bean
    public SalaPersistencePort salaPersistence(){
        return new SalaJpaAdapter() ;
    }

    @Bean
    public SalaServicePort salaService(){
        return new SalaServiceImpl(salaPersistence());
    }
}
