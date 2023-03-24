package org.example.configuration;

import org.example.adapters.EstadoJpaAdapter;
import org.exemple.ports.api.EstadoServicePort;
import org.exemple.ports.spi.EstadoPersistencePort;
import org.exemple.service.EstadoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EstadoConfig {
    @Bean
    public EstadoPersistencePort estadoPersistence(){
        return new EstadoJpaAdapter() ;
    }

    @Bean
    public EstadoServicePort estadoService(){
        return new EstadoServiceImpl(estadoPersistence());
    }
}
