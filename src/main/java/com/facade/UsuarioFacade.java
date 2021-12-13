package com.facade;

import com.service.ValidacaoService;
import com.v1.dto.request.UsuarioRequest;
import com.v1.dto.response.UsuarioResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UsuarioFacade {

    private ValidacaoService valida;

    public UsuarioResponse cadastra(UsuarioRequest usuario) {
        valida.validaUsuario(usuario.getEmail());
        return mapUsuarioModelToResponse(mapUsuarioRequestToModel(usuario));
    }
}