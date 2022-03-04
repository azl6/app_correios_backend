package com.alex.projeto_correios.services;

import com.alex.projeto_correios.domain.Cliente;
import com.alex.projeto_correios.domain.Encomenda;
import com.alex.projeto_correios.domain.enums.Status;
import com.alex.projeto_correios.exceptions.ArgumentNotAcceptedException;
import com.alex.projeto_correios.exceptions.ObjectNotFoundException;
import com.alex.projeto_correios.repositories.EncomendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EncomendaService {

    @Autowired
    private EncomendaRepository repo;

    @Autowired
    private EmailService emailService;

    public Encomenda findByCodigo(String codigo){
        Optional<Encomenda> obj = repo.findByCodigo(codigo);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Encomenda> findAll(){
        return repo.findAll();
    }

    public Encomenda findById(Integer id){
        Optional<Encomenda> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public Encomenda insert(Encomenda obj){
        Optional<Encomenda> opt = repo.findByCodigo(obj.getCodigo());

        if(opt.isPresent())
            throw new ArgumentNotAcceptedException("Código já existente na base de dados");
        else
            return repo.save(obj);
    }

    public Encomenda updateStatus(Integer id, String status){
        status = status.toUpperCase();
        status = status.substring(18, status.length()-4);
        Encomenda old = this.findById(id);

        if (old == null)
            throw new ObjectNotFoundException("Objeto não encontrado");

        switch (status){
            case "ENVIADO":
                old.setStatus(Status.ENVIADO);
                break;
            case "PENDENTE_DE_ENVIO":
                old.setStatus(Status.PENDENTE_DE_ENVIO);
                break;
            case "ENTREGUE":
                old.setStatus(Status.ENTREGUE);
                break;
            default:
                throw new IllegalArgumentException("Status informado não existente");
        }
        return repo.save(old);
    }

    public void sendStatusEmail(Encomenda encomenda, Cliente cliente){
        emailService.sendStatusChangedEmail(cliente, encomenda);
    }
}
