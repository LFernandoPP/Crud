package com.domain.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(value = "Usuarios")
public class UsuarioEntity {

    @Id
    private String id;
    private String email;
    private String nome;
    private String senha;
}