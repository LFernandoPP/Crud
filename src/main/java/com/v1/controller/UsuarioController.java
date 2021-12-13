package com.v1.controller;

import com.facade.UsuarioFacade;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping(path = "/usuario")
@RestController
public class UsuarioController {

    private UsuarioFacade facade;

    @PostMapping
    public UsuarioResponse cadastra(UsuarioRequest usuario) {
        return facade.cadastra(usuario);
    }
}