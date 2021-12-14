package com.domain.entity;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(value = "Usuario")
public class UsuarioEntity {

    @Indexed(unique = true)
    private String email;
    private String nome;
    private String senha;
}