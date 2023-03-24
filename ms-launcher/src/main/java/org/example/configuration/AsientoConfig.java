package org.example.configuration;

import org.example.adapters.AsientoJpaAdapter;
import org.exemple.ports.api.AsientoServicePort;
import org.exemple.ports.spi.AsientoPersistencePort;
import org.exemple.service.AsientoServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AsientoConfig {
    @Bean
    public AsientoPersistencePort asientoPersistence(){
        return new AsientoJpaAdapter() ;
    }

    @Bean
    public AsientoServicePort asientoService(){
        return new AsientoServiceImpl(asientoPersistence());
    }

}
