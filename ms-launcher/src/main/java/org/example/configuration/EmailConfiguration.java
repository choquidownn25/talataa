package org.example.configuration;

import org.exemple.service.EmailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailConfiguration {

    @Bean
    public EmailServiceImpl emailService(){return new EmailServiceImpl();}


}
