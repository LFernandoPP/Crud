package com.domain.repository;

import com.domain.entity.UsuarioEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<UsuarioEntity, String> {
    UsuarioEntity findByEmail(String email);
    void deleteByEmail(String email);
}