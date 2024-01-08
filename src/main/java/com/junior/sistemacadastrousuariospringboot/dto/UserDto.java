package com.junior.sistemacadastrousuariospringboot.dto;

import com.junior.sistemacadastrousuariospringboot.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    
    private Long id;
    private String username;
    private Integer year;

    public UserDto(User user){
        id = user.getId();
        username = user.getUsername();
        year = user.getYear();
    }

}
