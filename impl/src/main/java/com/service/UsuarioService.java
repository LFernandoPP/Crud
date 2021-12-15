package com.service;

import com.domain.entity.UsuarioEntity;
import com.domain.repository.UsuarioRepository;
import com.exception.ApiException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UsuarioService {

    private UsuarioRepository repository;

    public UsuarioEntity cadastro(UsuarioEntity usuario) {
        return repository.save(usuario);
    }

    public UsuarioEntity buscaPorEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new ApiException("Usuario não encontrado", HttpStatus.NOT_FOUND));
    }

    public UsuarioEntity atualiza(UsuarioEntity novoUsuario) {
        return repository.save(novoUsuario);
    }

    public void deleta(String email) {
        repository.delete(buscaPorEmail(email));
    }
}