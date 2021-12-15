package com.stubs;

import com.domain.entity.UsuarioEntity;

public class UsuarioEntityStub{

    public static UsuarioEntity generateUsuarioEntity(){
        return UsuarioEntity
                .builder()
                .id("123qwe")
                .email("qwe@asd2")
                .nome("qwertyuio2")
                .senha("123456782")
                .build();
    }
}