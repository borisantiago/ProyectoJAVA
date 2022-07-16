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

import com.bit.proyecto.modelo.Pedido;
import com.bit.proyecto.modelo.dto.PedidoDTO;
import com.bit.proyecto.servicio.PedidoRepository;


@RestController
@RequestMapping("/pedido")
public class PedidoController {
    
    @Autowired
    private PedidoRepository repository;

    @GetMapping("/todos")
    public ResponseEntity<List<Pedido>> pedidosLista(){
        List<Pedido> pedidos = repository.buscarTodos();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }
    
    @GetMapping("/todosDTO")
    public ResponseEntity<List<PedidoDTO>> pedidos(){
        List<PedidoDTO> pedidos = repository.buscarTodos2();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> buscarUnico(@PathVariable Integer id){
        PedidoDTO per = repository.buscarUnico(id);
        return new ResponseEntity<>(per, HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> crearPedido(@RequestBody PedidoDTO pedidoDTO){
        repository.guardarPedido(pedidoDTO);
        return new ResponseEntity<>(pedidoDTO, HttpStatus.CREATED);
    }

    @PostMapping("/actualizar")
    public ResponseEntity<?> actualizarPedido(@RequestBody PedidoDTO pedidoDTO){
        
        PedidoDTO per = repository.actualizarPedido(pedidoDTO);
        return new ResponseEntity<>(per, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPedido(@PathVariable("id") Integer id){
        repository.eliminarPedido(id);
        return new ResponseEntity<>("Se elimino correctamente", HttpStatus.OK);
    }

}
