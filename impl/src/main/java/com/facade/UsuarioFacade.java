package com.facade;

import com.service.UsuarioService;
import com.service.ValidacaoService;
import com.v1.dto.request.UsuarioRequest;
import com.v1.dto.response.UsuarioResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.v1.mapper.UsuarioMapper.mapUsuarioEntityToResponse;
import static com.v1.mapper.UsuarioMapper.mapUsuarioRequestToEntity;
import static java.util.Arrays.stream;

@AllArgsConstructor
@Component
public class UsuarioFacade {

    private UsuarioService usuarioService;
    private ValidacaoService validacaoService;

    public UsuarioResponse cadastra(UsuarioRequest usuario) {
        return mapUsuarioEntityToResponse(usuarioService.cadastro(mapUsuarioRequestToEntity(usuario)));
    }

    public UsuarioResponse buscaEmail(String email) {
        validacaoService.validaUsuario(email);
        return mapUsuarioEntityToResponse(usuarioService.buscaPorEmail(email));
    }

    public void deleta(String email) {
        usuarioService.deleta(email);
    }

    public UsuarioResponse atualiza(UsuarioRequest usuario) {
        validacaoService.validaUsuario(usuario.getEmail());
        return mapUsuarioEntityToResponse(usuarioService.atualiza(mapUsuarioRequestToEntity(usuario)));
    }

    public List<UsuarioResponse> lista() {
        validacaoService.validaLista();

        return usuarioService.lista().stream().map(usuario -> UsuarioResponse.builder()
                .email(usuario.getEmail())
                .nome(usuario.getNome())
                .senha(usuario.getSenha())
                .build()).collect(Collectors.toList());
    }
}