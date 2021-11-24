package com.junior.sistemacadastrousuariospringboot.services.exceptions;

public class EmailExistsException extends RuntimeException {

    public EmailExistsException(String email){
        super("E-mail já cadastrado: " + email);
    }

}