package com.service;

import com.domain.entity.UsuarioEntity;
import com.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UsuarioService {

    private UsuarioRepository repository;

    public UsuarioEntity cadastro(UsuarioEntity usuario){
        return repository.insert(usuario);
    }

    public UsuarioEntity buscaPorEmail(String email) {
        return repository.findByEmail(email);
    }

    public UsuarioEntity atualiza(UsuarioEntity novoUsuario){
        UsuarioEntity usuario = buscaPorEmail(novoUsuario.getEmail());
        novoUsuario.setId(usuario.getId());
        return repository.save(novoUsuario);
    }

    public void deleta(String email){
        repository.delete(buscaPorEmail(email));
    }
}