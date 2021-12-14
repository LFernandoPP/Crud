package com.v1.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioRequest {

    @Email
    private String email;

    @Size(min = 2, max = 40, message = ("Tamanho - Min 2 | Max 40"))
    private String nome;

    @Size(min = 6, max = 40, message = ("Tamanho - Min 6 | Max 40"))
    private String senha;
}