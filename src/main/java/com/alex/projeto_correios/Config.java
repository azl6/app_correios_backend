package com.alex.projeto_correios;

import com.alex.projeto_correios.services.EmailService;
import com.alex.projeto_correios.services.MockEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public EmailService emailService(){
        return new MockEmailService();
    }
}
