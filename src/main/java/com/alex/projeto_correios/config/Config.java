package com.alex.projeto_correios.config;

import com.alex.projeto_correios.services.EmailService;
import com.alex.projeto_correios.services.MockEmailService;
import com.alex.projeto_correios.services.SmtpEmailService;
import com.alex.projeto_correios.utils.CodeGenerator;
import com.alex.projeto_correios.utils.EncomendaIdGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    @Bean
    public CodeGenerator codeGenerator(){
        return new CodeGenerator();
    }

    @Bean
    public EncomendaIdGenerator encomendaIdGenerator(){
        return new EncomendaIdGenerator();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
