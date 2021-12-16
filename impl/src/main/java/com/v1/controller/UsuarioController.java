package com.v1.controller;

import com.exception.ExceptionResponse;
import com.facade.UsuarioFacade;
import com.v1.dto.request.UsuarioRequest;
import com.v1.dto.response.UsuarioResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "Usuario controller")
@AllArgsConstructor
@RequestMapping(path = "/crud/v1")
@RestController
public class UsuarioController {

    private UsuarioFacade facade;

    @ApiOperation(value = "Cria um novo usuario")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Usuario criado"),
            @ApiResponse(code = 400, message = "Requisição ruim", response = ExceptionResponse.class),
            @ApiResponse(code = 500, message = "Erro interno do servidor", response = ExceptionResponse.class)
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/usuario")
    public UsuarioResponse cadastra(@Valid @RequestBody UsuarioRequest usuario) {
        return facade.cadastra(usuario);
    }

    @ApiOperation(value = "Busca o usuario pelo email")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Usuario encontrado"),
            @ApiResponse(code = 404, message = "Usuario não encontrado", response = ExceptionResponse.class),
            @ApiResponse(code = 500, message = "Erro interno do servidor", response = ExceptionResponse.class)
    })
    @GetMapping("/usuario")
    public UsuarioResponse buscaEmail(@RequestParam String email) {
        return facade.buscaEmail(email);
    }

    @ApiOperation(value = "Deleta o usuario")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Usuario deletado"),
            @ApiResponse(code = 404, message = "Usuario não encontrado", response = ExceptionResponse.class),
            @ApiResponse(code = 500, message = "Erro interno do servidor", response = ExceptionResponse.class)
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/usuario/{email}")
    public void deleta(@PathVariable String email) {
        facade.deleta(email);
    }
}