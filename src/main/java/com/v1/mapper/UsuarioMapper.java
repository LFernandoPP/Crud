package com.v1.mapper;

import com.domain.entity.UsuarioEntity;
import com.v1.dto.request.UsuarioRequest;
import com.v1.dto.response.UsuarioResponse;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UsuarioMapper {

    public static UsuarioEntity mapUsuarioRequestToEntity(UsuarioRequest usuario) {
        return UsuarioEntity
                .builder()
                .email(usuario.getEmail())
                .nome(usuario.getNome())
                .senha(usuario.getSenha())
                .build();
    }

    public static UsuarioResponse mapUsuarioEntityToResponse(UsuarioEntity usuario) {
        return UsuarioResponse
                .builder()
                .email(usuario.getEmail())
                .nome(usuario.getNome())
                .senha(usuario.getSenha())
                .build();
    }
}