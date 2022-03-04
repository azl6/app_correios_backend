package com.alex.projeto_correios.controllers;

import com.alex.projeto_correios.domain.Cliente;
import com.alex.projeto_correios.services.ClienteService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/forgot")
public class ForgotPasswordController {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> newPassword(@RequestBody String response){
        JsonObject data = new Gson().fromJson(response, JsonObject.class);
        JsonElement emailJson = data.get("email");
        String email = emailJson.toString().replace("\"","");
        Cliente obj = clienteService.findByEmail(email);
        obj = clienteService.newPassword(obj);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}