package com.service;

import com.domain.entity.UsuarioEntity;
import com.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UsuarioService {

    private UsuarioRepository repository;

    public UsuarioEntity cadastro(UsuarioEntity usuario) {
        return repository.save(usuario);
    }

    public UsuarioEntity buscaPorEmail(String email) {
        return repository.findByEmail(email);
    }

    public UsuarioEntity atualiza(UsuarioEntity novoUsuario) {
        novoUsuario.setId(repository.findByEmail(novoUsuario.getEmail()).getId());
        return repository.save(novoUsuario);
    }

    public void deleta(String email) {
        repository.deleteByEmail(email);
    }

    public List<UsuarioEntity> lista() {
        return repository.findAll();
    }
}