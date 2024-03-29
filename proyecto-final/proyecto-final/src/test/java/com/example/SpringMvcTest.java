package com.example;

import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.bit.proyecto.dao.ZapatoDao;
import com.bit.proyecto.modelo.Zapato;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ZapatoDao mockRepository;

    @Before
    public void init() {
        Zapato zapato = new Zapato("100", "Reebok", "Casuales", "M", "Gris", "40", 9, 60.0, "imagen");
        Mockito.when(mockRepository.findById("1")).thenReturn(Optional.of(zapato));
    }

    //@WithMockUser("user")
    @Test
    public void buscaId() throws Exception {
        mockMvc.perform(get("/zapato/100"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.zapCodigo", Matchers.is("100")))
                .andExpect(jsonPath("$.zapNombre", Matchers.is("Reebok")))
                .andExpect(jsonPath("$.zapModelo", Matchers.is("Casuales")))
                .andExpect(jsonPath("$.zapGenero", Matchers.is("M")))
                .andExpect(jsonPath("$.zapColor", Matchers.is("Gris")))
                .andExpect(jsonPath("$.zapTalla", Matchers.is("40")))
                .andExpect(jsonPath("$.zapStock", Matchers.is(9)))
                .andExpect(jsonPath("$.zapPrecio", Matchers.is(60.0)));

    }

    @Test
    public void error() throws Exception {     
        mockMvc.perform(get("/zapato/100"))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    
}
