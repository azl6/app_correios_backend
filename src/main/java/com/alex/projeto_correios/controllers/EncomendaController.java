package com.alex.projeto_correios.controllers;

import com.alex.projeto_correios.domain.Cliente;
import com.alex.projeto_correios.domain.Encomenda;
import com.alex.projeto_correios.services.ClienteService;
import com.alex.projeto_correios.services.EncomendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/encomendas")
public class EncomendaController {

    @Autowired
    private EncomendaService service;

    @RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
    public ResponseEntity<Encomenda> findByCodigo(@PathVariable String codigo){

            Encomenda obj = service.findByCodigo(codigo);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Encomenda>> findAll(){

        List<Encomenda> obj = service.findAll();
        return ResponseEntity.ok().body(obj);
    }
}
