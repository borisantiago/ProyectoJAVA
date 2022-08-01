package com.bit.proyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.proyecto.modelo.Persona;
import com.bit.proyecto.modelo.dto.PersonaDTO;
import com.bit.proyecto.security.AuthResponse;
import com.bit.proyecto.security.jwt.JwtTokenUtil;
import com.bit.proyecto.servicio.PersonaRepository;

@RestController
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaRepository repository;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JwtTokenUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> loginProfesor(@RequestBody Persona p){
        Persona personaDB = repository.loginPersona(p);
        
        if(personaDB != null){

            Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    p.getPerEmail(), p.getPerPassword())
            );
            Persona per = (Persona) authentication.getPrincipal();
            String accessonToken = jwtUtil.generateAccessToken(p);
            AuthResponse response = new AuthResponse(per.getPerEmail(), accessonToken);
            
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Usuario o contraseña incorrectos!", HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/todos")
    public ResponseEntity<List<Persona>> todosPersonas(){
        List<Persona> personas = repository.buscarTodos();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<PersonaDTO> buscarUnicoDTO(@PathVariable Integer id){
        PersonaDTO per = repository.buscarUnicoDTO(id);
        return new ResponseEntity<>(per, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> buscarUnico(@PathVariable Integer id){
        Persona per = repository.buscarUnico(id);
        return new ResponseEntity<>(per, HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> crearPersona(@RequestBody PersonaDTO personaDTO){
        repository.guardarPersona(personaDTO);
        return new ResponseEntity<>(personaDTO, HttpStatus.CREATED);
    }

    @PostMapping("/actualizar")
    public ResponseEntity<?> actualizarPersona(@RequestBody PersonaDTO personaDTO){
        
        PersonaDTO per = repository.actualizarPersona(personaDTO);
        return new ResponseEntity<>(per, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPersona(@PathVariable("id") Integer id){
        repository.eliminarPersona(id);
        return new ResponseEntity<>("Se elimino correctamente", HttpStatus.OK);
    }
    
    
    
}
