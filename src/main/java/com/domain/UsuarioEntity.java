package com.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(value = "Usuarios")
public class UsuarioEntity {

    private String email;
    private String nome;
    private String senha;
}