package com.stubs;

import com.domain.entity.UsuarioEntity;

public class UsuarioEntityStub{

    public static UsuarioEntity generateUsuarioEntity(){
        return UsuarioEntity
                .builder()
                .email("qwe@asd")
                .nome("qwertyuio")
                .senha("12345678")
                .build();
    }
}