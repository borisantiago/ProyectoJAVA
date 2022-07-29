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
import org.springframework.web.bind.annotation.RestController;

import com.bit.proyecto.modelo.Entrega;
import com.bit.proyecto.modelo.dto.EntregaDTO;
import com.bit.proyecto.servicio.EntregaRepository;

@RestController
@RequestMapping("/entrega")
public class EntregaController {

    @Autowired
    private EntregaRepository repository;

    @GetMapping("/todos")
    public ResponseEntity<List<Entrega>> todosEntrega(){
        List<Entrega> entrega = repository.buscarTodos();
        return new ResponseEntity<>(entrega, HttpStatus.OK);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<EntregaDTO> buscarUnicoDTO(@PathVariable Integer id){
        EntregaDTO per = repository.buscarUnicoDTO(id);
        return new ResponseEntity<>(per, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrega> buscarUnico(@PathVariable Integer id){
        Entrega per = repository.buscarUnico(id);
        return new ResponseEntity<>(per, HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> crearPersona(@RequestBody EntregaDTO personaDTO){
        repository.guardarEntrega(personaDTO);
        return new ResponseEntity<>(personaDTO, HttpStatus.CREATED);
    }

    @PostMapping("/actualizar")
    public ResponseEntity<?> actualizarPersona(@RequestBody EntregaDTO entregaDTO){
        
        EntregaDTO per = repository.actualizarEntrega(entregaDTO);
        return new ResponseEntity<>(per, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPersona(@PathVariable("id") Integer id){
        repository.eliminarEntrega(id);
        return new ResponseEntity<>("Se elimino correctamente", HttpStatus.OK);
    }

    
    
}
