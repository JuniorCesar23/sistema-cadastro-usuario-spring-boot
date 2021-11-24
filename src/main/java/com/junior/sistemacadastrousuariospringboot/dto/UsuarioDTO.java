package com.junior.sistemacadastrousuariospringboot.dto;

import com.junior.sistemacadastrousuariospringboot.entities.Usuario;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UsuarioDTO {
    
    private Long id;
    private String nomeCompleto;
    private Integer idade;

    public UsuarioDTO(Usuario usuario){
        id = usuario.getId();
        nomeCompleto = usuario.getNomeCompleto();
        idade = usuario.getIdade();
    }

}
