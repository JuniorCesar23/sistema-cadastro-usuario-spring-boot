package com.junior.sistemacadastrousuariospringboot.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Long id) {
        super("Resource not found: " + id);
    }

}
