package com.alex.projeto_correios.utils;

import com.alex.projeto_correios.security.UserSpringSecurity;
import org.springframework.security.core.context.SecurityContextHolder;

public class LoggedUserUtils {

    public static UserSpringSecurity getAuthenticatedUser(){
        try{
            return (UserSpringSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }catch (Exception e){
            return null;
        }
    }
}
