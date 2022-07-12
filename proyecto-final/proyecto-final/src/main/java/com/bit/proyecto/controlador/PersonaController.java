package com.bit.proyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bit.proyecto.modelo.Persona;
import com.bit.proyecto.servicio.PersonaRepository;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaRepository repository;

    @GetMapping("/todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Persona> personas(){
        return repository.buscarTodos();
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> crearPersona(@RequestBody Persona persona) throws Exception{
        repository.guardarPersona(persona);
        return new ResponseEntity<>(persona, HttpStatus.CREATED);
    }

    

    
    
}
