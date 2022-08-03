package com.bit.proyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.proyecto.modelo.Carrito;
import com.bit.proyecto.servicio.CarritoRepository;


@RestController
@RequestMapping("/carrito")
@CrossOrigin("*")
public class CarritoController {
    
    @Autowired
    private CarritoRepository repository;

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<Carrito>> filtarcliente(@PathVariable Integer id){
        List<Carrito> carr = repository.buscarZapatosEnCarrito(id);
        return new ResponseEntity<>(carr, HttpStatus.OK);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Carrito>> todosCarrito(){
        List<Carrito> carrito = repository.buscarTodos();
        return new ResponseEntity<>(carrito, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrito> buscarUnico(@PathVariable Integer id){ 
        Carrito per = repository.buscarUnico(id);
        return new ResponseEntity<>(per, HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> crearCarrito(@RequestBody Carrito carrito){
        repository.guardarCarrito(carrito);
        return new ResponseEntity<>(carrito, HttpStatus.CREATED);
    }

    @PostMapping("/actualizar")
    public ResponseEntity<?> actualizarPersona(@RequestBody Carrito carrito){
        
        Carrito per = repository.actualizarCarrito(carrito);
        return new ResponseEntity<>(per, HttpStatus.OK);
    }


    

}
