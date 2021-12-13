package com.domain.repository;

import com.domain.entity.UsuarioEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<UsuarioEntity, String> {
    UsuarioEntity findByEmail(String email);
}