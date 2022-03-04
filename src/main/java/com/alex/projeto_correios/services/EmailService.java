package com.alex.projeto_correios.services;

import com.alex.projeto_correios.domain.Cliente;
import com.alex.projeto_correios.domain.Encomenda;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    void sendStatusChangedEmail(Cliente cliente, Encomenda encomenda);
    void sendEmail(SimpleMailMessage msg);
    void sendNewPasswordEmail(Cliente cliente);
}
