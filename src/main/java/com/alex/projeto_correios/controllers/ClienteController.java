package com.alex.projeto_correios.controllers;

import com.alex.projeto_correios.domain.Cliente;
import com.alex.projeto_correios.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Cliente obj){

    service.update(id, obj);

    return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> findById(@PathVariable Integer id){

        Cliente obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Cliente>> findAll(){

        List<Cliente> obj = service.findAll();
        return ResponseEntity.ok().body(obj);
    }
}
