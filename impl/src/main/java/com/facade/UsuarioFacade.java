package com.facade;

import com.service.UsuarioService;
import com.service.ValidacaoService;
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
    private ValidacaoService valida;

    public UsuarioResponse cadastra(UsuarioRequest usuario) {
        return mapUsuarioEntityToResponse(service.cadastro(mapUsuarioRequestToEntity(usuario)));
    }

    public UsuarioResponse buscaEmail(String email) {
        valida.validaUsuario(email);
        return mapUsuarioEntityToResponse(service.buscaPorEmail(email));
    }
}