package com.v1.controller;

import com.domain.repository.UsuarioRepository;
import com.facade.UsuarioFacade;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.UsuarioService;
import com.service.ValidacaoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.stubs.UsuarioEntityStub.generateUsuarioEntity;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UsuarioController.class)
@ContextConfiguration(classes = {UsuarioController.class,
        UsuarioFacade.class,
        ValidacaoService.class,
        UsuarioService.class})
@AutoConfigureMockMvc
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioRepository repository;

    @Test
    public void cadastra_ReturnCode_Created() throws Exception {
        given(repository.save(any())).willReturn(generateUsuarioEntity());
        this.mockMvc.perform(post("/crud/v1/usuario")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper()
                                .writeValueAsString(generateUsuarioEntity())))
                .andExpect(status().isCreated());
    }

    @Test
    public void buscaEmail_ReturnCode_Ok() throws Exception {
        given(repository.findByEmail(any())).willReturn(generateUsuarioEntity());
        this.mockMvc.perform(get("/crud/v1/usuario")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("email", generateUsuarioEntity().getEmail()))
                .andExpect(status().isOk());
    }
}