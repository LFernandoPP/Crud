package com.stubs;

import com.domain.entity.UsuarioEntity;

import java.util.ArrayList;
import java.util.List;

public class UsuarioEntityStub {

    public static UsuarioEntity generateUsuarioEntity() {
        return UsuarioEntity
                .builder()
                .id("123qwe")
                .email("qwe@asd2")
                .nome("qwertyuio2")
                .senha("123456782")
                .build();
    }

    public static List<UsuarioEntity> generateListUsuarioEntity() {
        List<UsuarioEntity> lista = new ArrayList<>();
        lista.add(generateUsuarioEntity());
        lista.add(generateUsuarioEntity());
        lista.add(generateUsuarioEntity());
        return lista;
    }
}