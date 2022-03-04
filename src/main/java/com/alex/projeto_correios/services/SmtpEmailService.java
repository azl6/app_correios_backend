package com.alex.projeto_correios.services;

import com.alex.projeto_correios.domain.Cliente;
import com.alex.projeto_correios.domain.Encomenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

public abstract class SmtpEmailService implements EmailService {

    @Value("${default.sender}")
    private String sender;

    @Autowired
    private MailSender mailSender;

    @Autowired
    private BCryptPasswordEncoder pe;

    public void sendStatusChangedEmail(Cliente cli, Encomenda enc){
       SimpleMailMessage sm = this.prepareSimpleMailMessageForCliente(cli, enc);
       mailSender.send(sm);
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

    public void sendNewPasswordEmail(Cliente cli){
        SimpleMailMessage sm = this.prepareSimpleMailMessageForNewPassword(cli);
        mailSender.send(sm);
    }

    protected SimpleMailMessage prepareSimpleMailMessageForNewPassword(Cliente obj){
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(obj.getEmail());
        sm.setFrom(sender);
        sm.setSubject("Pedido de nova senha");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText("Saudações, " + obj.getNome() + ".\n\nEsperamos que esteja bem!" +
                "\n\nAtendendo o seu pedido, aqui está a sua nova senha: " + obj.getSenha() +
                "\n\nAbraços,\n\nEquipe Correios");

        return sm;
    }
}
