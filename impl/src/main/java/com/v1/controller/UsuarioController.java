package com.v1.controller;

import com.exception.ExceptionResponse;
import com.facade.UsuarioFacade;
import com.v1.dto.request.UsuarioRequest;
import com.v1.dto.response.UsuarioResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RequestMapping(path = "/crud/v1")
@RestController
public class UsuarioController {

    private UsuarioFacade facade;

    @ApiOperation(value = "Cria um novo usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Usuario criado"),
            @ApiResponse(code = 400, message = "Requisição ruim", response = ExceptionResponse.class),
            @ApiResponse(code = 500, message = "Erro interno do servidor", response = ExceptionResponse.class)
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/usuario")
    public UsuarioResponse cadastra(@Valid @RequestBody UsuarioRequest usuario) {
        return facade.cadastra(usuario);
    }
}