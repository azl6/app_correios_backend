package com.alex.projeto_correios.exceptions;

public class AccessDeniedException extends RuntimeException{

    public AccessDeniedException(String msg){
        super(msg);
    }
}
