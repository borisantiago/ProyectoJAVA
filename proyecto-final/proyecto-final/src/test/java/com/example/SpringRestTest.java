package com.example;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.bit.proyecto.dao.ZapatoDao;
import com.bit.proyecto.modelo.Zapato;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringRestTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private ZapatoDao mockRepository;

    @Before
    public void init() {
        Zapato zapato = new Zapato("1", "Reebok", "Atleta", "F", "Gris", "38", 99, 55.0);
        Mockito.when(mockRepository.findById("1")).thenReturn(Optional.of(zapato));
    }

    @Test
    public void loginOK() throws Exception {
        ResponseEntity<String> response = restTemplate.withBasicAuth("user", "password").getForEntity("/zapato/1", String.class);                
        System.out.println("===================== LOGIN OK RESPONSE ==============================");
        System.out.println(response.getBody());
        System.out.println("======================================================================");
        Assert.assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());    
        ObjectMapper maper = new ObjectMapper();
        Zapato resultado = maper.readValue(response.getBody(), Zapato.class);
        System.out.println("RESULTADO OBJ  " + resultado);
        Assert.assertEquals("1", resultado.getZapCodigo());        
    }
    
}
