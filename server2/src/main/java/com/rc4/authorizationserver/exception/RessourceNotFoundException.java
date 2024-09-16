package com.rc4.authorizationserver.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RessourceNotFoundException extends RuntimeException{

    public RessourceNotFoundException(String ressourceName, String fieldName, String fieldValue) {
        super(String.format("%s not found with the given input data %s: '%s'",
                ressourceName,
                fieldName,
                fieldValue));
    }
}
