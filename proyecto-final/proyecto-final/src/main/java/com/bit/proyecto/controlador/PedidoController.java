package com.bit.proyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bit.proyecto.config.TokenLogin;
import com.bit.proyecto.modelo.Pedido;
import com.bit.proyecto.modelo.dto.PedidoDTO;
import com.bit.proyecto.rest.Output;
import com.bit.proyecto.servicio.PedidoRepository;


@RestController
@RequestMapping("/pedido")
public class PedidoController {
    
    @Autowired
    private PedidoRepository repository;

    @Autowired
    TokenLogin tokens;

    //Buscar pedidos de una persona
    @GetMapping("/persona")
    public Output getPedidosPersona(@RequestParam("id") Integer id){
        Output salida = new Output();
         salida.setCodigo("200");
         salida.setMensaje("Pedidos del cliente id " +id +" son: ");
         salida.setEntidad(repository.pedidosPorIdCliente(id));

         return salida;
    }

    //GestionarPedido
    @PostMapping("/comprar")
    public ResponseEntity<String> gestionarEstado(@RequestBody Pedido p){
        repository.actualizarPedidoP(p);
        return new ResponseEntity<>("Se actualizado el estado correctamente '"+ p.getPedEstado() + "' de cliente '"+p.getPedCodigo()+"'", HttpStatus.OK);
    }

    @GetMapping("/persona/{id}")
    public ResponseEntity<List<PedidoDTO>> getCatalogo2(@PathVariable Integer id){
        List<PedidoDTO> zaps = repository.pedidosPorIdCliente(id);
        return new ResponseEntity<>(zaps, HttpStatus.OK);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Pedido>> pedidosLista(@RequestHeader("token") String token){
        List<Pedido> pedidos = repository.buscarTodos();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }
    
    @GetMapping("/todosDTO")
    public ResponseEntity<List<PedidoDTO>> pedidos(){
        List<PedidoDTO> pedidos = repository.buscarTodos2();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarUnico(@PathVariable Integer id, @RequestHeader("token") String token){
        Pedido per = repository.buscarUnico1(id);
        return new ResponseEntity<>(per, HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> crearPedido(@RequestBody PedidoDTO pedidoDTO, @RequestHeader("token") String token){
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
