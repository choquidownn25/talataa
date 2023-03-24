package org.example.configuration;

import org.example.adapters.CarteleraJpaAdapter;
import org.exemple.ports.api.CarteleraServicePort;
import org.exemple.ports.spi.CarteleraPersistencePort;
import org.exemple.service.CarteleraServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarteleraConfig {
    @Bean
    public CarteleraPersistencePort carteleraPersistence(){
        return new CarteleraJpaAdapter() ;
    }

    @Bean
    public CarteleraServicePort carteleraService(){
        return new CarteleraServiceImpl(carteleraPersistence());
    }
}
