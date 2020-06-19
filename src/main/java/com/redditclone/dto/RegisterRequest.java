package com.redditclone.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    //classe com as informações de cadastro do usuario
    private String email;
    private String username;
    private String password;
}
