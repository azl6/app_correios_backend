package com.alex.projeto_correios;

import com.alex.projeto_correios.services.EmailService;
import com.alex.projeto_correios.services.MockEmailService;
import com.alex.projeto_correios.services.SmtpEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

@Configuration
public class Config {

    @Bean
    public EmailService emailService(){
        return new SmtpEmailService() {
            @Override
            public void sendEmail(SimpleMailMessage msg) {

            }
        };
    }
}
