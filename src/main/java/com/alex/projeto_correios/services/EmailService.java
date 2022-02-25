package com.alex.projeto_correios.services;

import com.alex.projeto_correios.domain.Cliente;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    void sendStatusChangedEmail(Cliente obj);
    void sendEmail(SimpleMailMessage msg);
}
