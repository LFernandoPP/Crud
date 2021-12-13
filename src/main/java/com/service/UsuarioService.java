package com.service;

import com.domain.entity.UsuarioEntity;
import com.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UsuarioService {

    UsuarioRepository repository;

    public UsuarioEntity cadastroUnico(UsuarioEntity usuario){
        return repository.insert(usuario);
    }

}