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

import com.bit.proyecto.modelo.Zapato;
import com.bit.proyecto.modelo.dto.ZapatoDTO;
import com.bit.proyecto.servicio.ZapatoRepository;

@RestController
@RequestMapping("/zapato")
public class ZapatoController {
    
    @Autowired
    private ZapatoRepository repository;

    @GetMapping("/todosDTO")
    @ResponseStatus(HttpStatus.OK)
    public List<ZapatoDTO> zapatos(){
        return repository.listarZapatosDTO();
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Zapato>> buscarTodos(){
        List<Zapato> zaps = repository.todosZapatos();
        return new ResponseEntity<>(zaps, HttpStatus.OK);
    }

    @GetMapping("DTO/{id}")
    public ResponseEntity<ZapatoDTO> buscarUnicoDTO(@PathVariable String id){
        ZapatoDTO zap = repository.buscarUnicoDTO(id);
        return new ResponseEntity<>(zap, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zapato> buscarUnico(@PathVariable String id){
        Zapato zap = repository.buscarunico(id);
        return new ResponseEntity<>(zap, HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> crearZapato(@RequestBody ZapatoDTO zapatoDTO){
        repository.guardarZapato(zapatoDTO);
        return new ResponseEntity<>(zapatoDTO, HttpStatus.CREATED);
    }

    @PostMapping("/actualizar")
    public ResponseEntity<?> actualizarZapato(@RequestBody ZapatoDTO zapatoDTO){
        
        ZapatoDTO zap = repository.actualizarZapato(zapatoDTO);
        return new ResponseEntity<>(zap, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarZapato(@PathVariable("id") String id){
        repository.eliminarZapato(id);
        return new ResponseEntity<>("Se elimino correctamente", HttpStatus.OK);
    }



}
