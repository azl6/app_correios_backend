package com.alex.projeto_correios.services;

import com.alex.projeto_correios.domain.Cliente;
import com.alex.projeto_correios.domain.Encomenda;
import com.alex.projeto_correios.domain.enums.Status;
import com.alex.projeto_correios.repositories.ClienteRepository;
import com.alex.projeto_correios.repositories.EncomendaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class EncomendaService {

    @Autowired
    private EncomendaRepository repo;

    public Encomenda findByCodigo(String codigo){
        Optional<Encomenda> obj = repo.findByCodigo(codigo);

        return obj.orElseThrow(() -> new ObjectNotFoundException(1, "Não encontrado"));
    }

    public List<Encomenda> findAll(){
        return repo.findAll();
    }

    public Encomenda findById(Integer id){
        Optional<Encomenda> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(1, "Não encontrado"));
    }

    public Encomenda insert(Encomenda obj){
        Optional<Encomenda> opt = repo.findById(obj.getId());

        if(opt.isPresent())
            throw new IllegalArgumentException("Código já existente na base de dados");
        else
            return repo.save(obj);
    }

    public Encomenda updateStatus(Integer id, String status){
        status = status.toUpperCase();
        status = status.substring(18, status.length()-4);
        Encomenda old = this.findById(id);

        if (old == null)
            throw new ObjectNotFoundException(1, "Não encontrado");

        switch (status){
            case "ENVIADO":
                System.out.println("\ncaiu no ENVIADO!\n");
                System.out.println("Status: " + status);
                old.setStatus(Status.ENVIADO);
                break;
            case "PENDENTE_DE_ENVIO":
                System.out.println("\ncaiu no PENDENTE_DE_ENVIO!\n");
                System.out.println("Status: " + status);
                old.setStatus(Status.PENDENTE_DE_ENVIO);
                break;
            case "ENTREGUE":
                System.out.println("\ncaiu no ENTREGUE!\n");
                System.out.println("Status: " + status);
                old.setStatus(Status.ENTREGUE);
                break;
            default:
                throw new IllegalArgumentException("Status não existente, Status: " + status);
        }
        return repo.save(old);
    }
}
