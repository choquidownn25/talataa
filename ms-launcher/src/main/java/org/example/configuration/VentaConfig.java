package org.example.configuration;

import org.example.adapters.VentaJpaAdapter;
import org.exemple.ports.api.VentaServicePort;
import org.exemple.ports.spi.VentaPersistencePort;
import org.exemple.service.VentaServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VentaConfig {
    @Bean
    public VentaPersistencePort ventaPersistence(){
        return new VentaJpaAdapter() ;
    }

    @Bean
    public VentaServicePort ventaService(){
        return new VentaServiceImpl(ventaPersistence());
    }
}
