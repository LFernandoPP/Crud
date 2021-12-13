package com.v1.mapper;

import com.domain.entity.UsuarioEntity;
import com.v1.dto.request.UsuarioRequest;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UsuarioMapper {

    public static UsuarioEntity mapUsuarioRequestToModel (UsuarioRequest usuario) {
        return UsuarioEntity
                .builder()
                .email(usuario.getEmail())
                .nome(usuario.getNome())
                .senha(usuario.getSenha())
                .build();
    }
}