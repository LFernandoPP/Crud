package com.service;

import com.domain.repository.UsuarioRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static com.stubs.UsuarioEntityStub.generateUsuarioEntity;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ValidacaoServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private UsuarioRepository repository;

    @InjectMocks
    private ValidacaoService valida;

    @Test
    public void validaUsuario_returnException() {
        expectedException.expectMessage("Usuario não encontrado");
        when(repository.findByEmail(any())).thenReturn(null);
        valida.validaUsuario(generateUsuarioEntity().getEmail());

    }
}