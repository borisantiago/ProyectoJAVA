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

import com.bit.proyecto.modelo.DetallePedido;
import com.bit.proyecto.modelo.dto.DetallePedidoDTO;
import com.bit.proyecto.modelo.dto.DetallePedidoDTO;
import com.bit.proyecto.servicio.DetallePedidoRepository;

@RestController
@RequestMapping("detalle_pedido")
public class DetallePedidoController {
    
    @Autowired
    private DetallePedidoRepository repository;

    @GetMapping("/todos")
    public ResponseEntity<List<DetallePedido>> todosDetallePEdido(){
        List<DetallePedido> detallePedido = repository.buscarTodos();
        return new ResponseEntity<>(detallePedido, HttpStatus.OK);
    } 

    @GetMapping("id/{id}")
    public ResponseEntity<DetallePedidoDTO> buscarUnicoDTO(@PathVariable Integer id){
        DetallePedidoDTO per = repository.buscarUnicoDTO(id);
        return new ResponseEntity<>(per, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedido> buscarUnico(@PathVariable Integer id){
        DetallePedido per = repository.buscarUnico(id);
        return new ResponseEntity<>(per, HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> crearDetallePedido(@RequestBody DetallePedidoDTO detallePedidoDTO){
        repository.guardarDetallePedido(detallePedidoDTO);
        return new ResponseEntity<>(detallePedidoDTO, HttpStatus.CREATED);
    }

    @PostMapping("/actualizar")
    public ResponseEntity<?> actualizarDetallePedido(@RequestBody DetallePedidoDTO detallePedidoDTO){
        
        DetallePedidoDTO per = repository.actualizarDetallePedido(detallePedidoDTO);
        return new ResponseEntity<>(per, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarDetallePedido(@PathVariable("id") Integer id){
        repository.eliminarDetallePedido(id);
        return new ResponseEntity<>("Se elimino correctamente", HttpStatus.OK);
    }

}
