package com.junior.sistemacadastrousuariospringboot.controllers.exceptions;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StandardError {

    private Instant instant;
    private Integer status;
    private String error;
    private String msg;
    private String path;
    
}
