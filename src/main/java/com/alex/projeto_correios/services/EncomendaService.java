package com.alex.projeto_correios.services;

import com.alex.projeto_correios.domain.Cliente;
import com.alex.projeto_correios.domain.Encomenda;
import com.alex.projeto_correios.repositories.ClienteRepository;
import com.alex.projeto_correios.repositories.EncomendaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
