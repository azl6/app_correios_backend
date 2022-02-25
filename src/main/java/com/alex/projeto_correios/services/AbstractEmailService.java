package com.alex.projeto_correios.services;

import com.alex.projeto_correios.domain.Cliente;
import com.alex.projeto_correios.domain.Encomenda;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;

public abstract class AbstractEmailService implements EmailService {

    @Value("${default.sender}")
    private String sender;

    public void sendStatusChangedEmail(Cliente cli, Encomenda enc){
       SimpleMailMessage sm = this.prepareSimpleMailMessageForCliente(cli, enc);
       sendEmail(sm);
    }

    protected SimpleMailMessage prepareSimpleMailMessageForCliente(Cliente obj, Encomenda enc){
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(obj.getEmail());
        sm.setFrom(sender);
        sm.setSubject("Atualização no status do pedido!");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText("Saudações, " + obj.getNome() +
                "!\n\nAtualizamos o status do seu pedido! " +
                "O status atual do seu pedido " + enc.getCodigo() + " foi modificado para: "
                + enc.getStatus() + ".\n\nTrabalhamos para que receba as suas encomendas " +
                "com uma rapidez líder no mercado!\n\nAbraços,\n\nEquipe Correios");

        return sm;
    }
}
