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

    public void validaUsuario(String email) {
        if (repository.findByEmail(email) == null) {
            throw new ApiException("Usuario não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    public void validaLista() {
        if (repository.findAll().isEmpty()) {
            throw new ApiException("Usuarios não encontrados", HttpStatus.NOT_FOUND);
        }
    }
}