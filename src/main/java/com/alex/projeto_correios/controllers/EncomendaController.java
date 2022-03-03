package com.alex.projeto_correios.controllers;

import com.alex.projeto_correios.domain.Cliente;
import com.alex.projeto_correios.domain.Encomenda;
import com.alex.projeto_correios.domain.enums.Status;
import com.alex.projeto_correios.services.ClienteService;
import com.alex.projeto_correios.services.EncomendaService;
import com.alex.projeto_correios.utils.CodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/encomendas")
public class EncomendaController {

    @Autowired
    private EncomendaService service;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CodeGenerator codeGenerator;

    @RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
    public ResponseEntity<Encomenda> findByCodigo(@PathVariable String codigo){

        Encomenda obj = service.findByCodigo(codigo);
        return ResponseEntity.ok().body(obj);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Encomenda>> findAll(){

        List<Encomenda> obj = service.findAll();
        System.out.println(codeGenerator.newCode());
        return ResponseEntity.ok().body(obj);
    }

//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public ResponseEntity<Encomenda> findById(@PathVariable Integer id){
//
//        Encomenda obj = service.findById(id);
//        return ResponseEntity.ok().body(obj);
//    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Encomenda> insert(@RequestBody Encomenda obj){

        obj = service.insert(obj);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Void> updateStatus(@PathVariable Integer id, @RequestBody String status){

        Encomenda encomenda = service.findById(id);


        //criar método separado para fazer o envio de email
        service.updateStatus(id, status);
        service.sendStatusEmail(encomenda, encomenda.getCliente());

        return ResponseEntity.noContent().build();
    }
}
