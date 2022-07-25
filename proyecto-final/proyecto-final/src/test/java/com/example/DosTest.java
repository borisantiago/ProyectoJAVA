package com.example;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.bit.proyecto.modelo.Persona;
import com.bit.proyecto.servicio.PersonaRepository;

import net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection.Response;


public class DosTest {
    
    // @MockBean
    // private PersonaRepository personService;
    
    // @Autowired
    // private TestRestTemplate restTemplate;

    // @Before
    // public void init() {
    //     Map map = new LinkedHashMap();
    //     map.put("code",1);
    //     map.put("codigo","1723568945");
    //     map.put("name","Boris");
    //     map.put("last_name","Aseicha");
    //     map.put("email","boris@gmail.com");
    //     map.put("orders",new ArrayList<>());
    //     Response response = new Response("Data found successfully","200",true,"11-02-1996",map);
    //     Mockito.when(personService.buscarUnico(id)).thenReturn(response);

    //     Persona person = new Persona("1723568945","Boris","Torres","Quito", new Date(),"M","boris@gmail.com");
    //     response = new Response("The codigo ("+person.getPerApellido()+") is already registered.","404",false,new Date());
    //     Mockito.when(personService.guardarPersona("dcdaadd3-ed03-3f5c-89ed-b3e4223f2fd3",person)).thenReturn(response);

    //     List<Persona> personList = new ArrayList<>();
    //     personList.add(person);
    //     personList.add(person);
    //     response = new Response("The codigo ("+person.getPerApellido()+") is already registered.","404",false);
    //     Mockito.when(personService.getPeople(Pageable.ofSize(1))).thenReturn(response);
    // }

    // @Test
    // public void saveNewPerson() throws Exception{
    //     Persona person = new Persona("1723568945","Boris","Torres","Quito", "M","boris@gmail.com");
    //     ResponseEntity<Response> response = restTemplate.withBasicAuth("user", "password").postForEntity("/people",person,Response.class);
    //     System.out.println(response);
    //     Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    // }


}
