package com.v1.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UsuarioResponse {

    private String email;
    private String nome;
    private String senha;
}