package com.bit.proyecto.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.bit.proyecto.config.TokenLogin;

@RestController
public class ConfigController  {

    @Autowired
    TokenLogin tokens;

    @GetMapping("login")
    public String login(@RequestHeader("Authorization") String auth){
        System.out.println(auth);
        return tokens.addToken(auth);
    }

    @GetMapping("valida")
    public String valida(String token){
        return "El token es valido " +tokens.exist(token);
    }
    
    
}
