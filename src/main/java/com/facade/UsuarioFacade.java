package com.facade;

import com.service.UsuarioService;
import com.v1.dto.request.UsuarioRequest;
import com.v1.dto.response.UsuarioResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static com.v1.mapper.UsuarioMapper.mapUsuarioEntityToResponse;
import static com.v1.mapper.UsuarioMapper.mapUsuarioRequestToEntity;

@AllArgsConstructor
@Component
public class UsuarioFacade {

    private UsuarioService service;

    public UsuarioResponse cadastra(UsuarioRequest usuario) {
        return mapUsuarioEntityToResponse(service.cadastro(mapUsuarioRequestToEntity(usuario)));
    }
}