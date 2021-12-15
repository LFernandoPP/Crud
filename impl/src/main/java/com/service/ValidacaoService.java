package com.service;

import com.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ValidacaoService {

    private UsuarioRepository repository;
}