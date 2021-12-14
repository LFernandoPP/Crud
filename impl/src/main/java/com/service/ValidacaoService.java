package com.service;

import com.domain.repository.UsuarioRepository;
import com.exception.ApiException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ValidacaoService {

    private UsuarioRepository repository;

    public void validaUsuario(String email){
        if(repository.findByEmail(email).getEmail().isEmpty()){
            throw new ApiException("Usuario nao encontrado", HttpStatus.NOT_FOUND);
        }
    }
}