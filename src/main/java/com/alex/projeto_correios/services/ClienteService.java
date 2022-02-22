package com.alex.projeto_correios.services;

import com.alex.projeto_correios.domain.Cliente;
import com.alex.projeto_correios.repositories.ClienteRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository repo;

    public ClienteService(ClienteRepository clienteRepository) {
        this.repo = clienteRepository;
    }

    public Cliente findById(Integer id){
        Optional<Cliente> obj = repo.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(1, "Não encontrado"));
    }

    public void delete(Cliente cli){
         repo.delete(cli);
    }

    public Cliente update(Integer id, Cliente new_cliente){
        Cliente old = this.findById(id);

        if (old == null)
            throw new ObjectNotFoundException(1, "Não encontrado");

        new_cliente.setId(old.getId());
        return repo.save(new_cliente);

    }

    public List<Cliente> findAll(){
        List<Cliente> obj = repo.findAll();
        return obj;

    }
}
