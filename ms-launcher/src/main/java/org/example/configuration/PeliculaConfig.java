package org.example.configuration;

import org.example.adapters.PeliculaJpaAdapter;
import org.exemple.ports.api.PeliculaServicePort;
import org.exemple.ports.spi.PeliculaPersistencePort;
import org.exemple.service.PeliculaServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PeliculaConfig {
    @Bean
    public PeliculaPersistencePort peliculaPersistence(){
        return new PeliculaJpaAdapter() ;
    }

    @Bean
    public PeliculaServicePort peliculaService(){
        return new PeliculaServiceImpl(peliculaPersistence());
    }
}
