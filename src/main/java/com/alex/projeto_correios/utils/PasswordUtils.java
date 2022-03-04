package com.alex.projeto_correios.utils;

import com.alex.projeto_correios.domain.Cliente;
import org.springframework.beans.factory.annotation.Autowired;

public class PasswordUtils {

    @Autowired
    private CodeGenerator codeGenerator;

    public String newPassword(){
        return codeGenerator.newCode();
    }
}