package com.service;

import com.domain.entity.UsuarioEntity;
import com.domain.repository.UsuarioRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static com.stubs.UsuarioEntityStub.generateUsuarioEntity;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class UsuarioServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private UsuarioRepository repository;

    @InjectMocks
    private UsuarioService service;

    @Test
    public void cadastro_AtivaRepositoy() {
        when(repository.insert(generateUsuarioEntity())).thenReturn(generateUsuarioEntity());
        service.cadastro(generateUsuarioEntity());
        verify(repository, times(1)).insert(generateUsuarioEntity());
    }
}