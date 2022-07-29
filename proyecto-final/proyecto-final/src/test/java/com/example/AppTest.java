package com.example;

import java.util.List;

import org.junit.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import com.bit.proyecto.modelo.Zapato;
import com.bit.proyecto.modelo.dto.ZapatoDTO;
import com.bit.proyecto.servicio.ZapatoRepository;

@SpringBootConfiguration
@SpringBootTest(properties = {"con=jdbc:mysql://localhost:3306/proyecto_java"})
class AppTest {

	@Mock
    ZapatoRepository repositorio;

    @Mock
    List<Zapato> zapatos;

    @Value("${con}")
    String con;


	

    @Test
    void construye() {
        Mockito.when(repositorio.todosZapatos()).thenReturn(zapatos);
        Mockito.doReturn(new ZapatoDTO("1")).when(zapatos).get(1);
    }

    @Test
    void testPro() {
        Assert.assertEquals("jdbc:mysql://localhost:3306/proyecto_java", con);
    }

	

}
