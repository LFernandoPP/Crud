package com.v1.controller;

import com.facade.UsuarioFacade;
import com.v1.dto.request.UsuarioRequest;
import com.v1.dto.response.UsuarioResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping(path = "/crud/v1")
@RestController
public class UsuarioController {

    private UsuarioFacade facade;

    @PostMapping("/usuario")
    public UsuarioResponse cadastra(UsuarioRequest usuario) {
        return facade.cadastra(usuario);
    }
}