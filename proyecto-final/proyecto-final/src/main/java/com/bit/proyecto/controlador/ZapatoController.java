package com.bit.proyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bit.proyecto.config.TokenLogin;
import com.bit.proyecto.modelo.Zapato;
import com.bit.proyecto.modelo.dto.ZapatoDTO;
import com.bit.proyecto.rest.Output;
import com.bit.proyecto.servicio.ZapatoRepository;

@RestController
@RequestMapping("/zapato")
public class ZapatoController {
    
    @Autowired
    private ZapatoRepository repository;

    @Autowired
    TokenLogin tokens;

    //filtrado por genero 
    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<ZapatoDTO>> getCatalogo2(@PathVariable String genero){
        List<ZapatoDTO> zaps = repository.buscarFiltrado(genero);
        return new ResponseEntity<>(zaps, HttpStatus.OK);
    }

    @GetMapping("/genero")
    public Output getCatalogoGenero(@RequestParam("genero") String genero){
        Output salida = new Output();
        salida.setCodigo("0");
        salida.setMensaje("Peticion procesada con exito");
        salida.setEntidad(repository.buscarFiltrado(genero));

        return salida;
    }

    //filtrado por talla
    @GetMapping("/talla/{talla}")
    public ResponseEntity<List<ZapatoDTO>> getCatalogoTalla(@PathVariable String talla){
        List<ZapatoDTO> zaps = repository.buscarFiltradoTalla(talla);
        return new ResponseEntity<>(zaps, HttpStatus.OK);

    }

    @GetMapping("/talla")
    public Output getCatalogo(@RequestParam("talla") String talla){
        Output salida = new Output();
        salida.setCodigo("0");
        salida.setMensaje("Peticion procesada con exito");
        salida.setEntidad(repository.buscarFiltradoTalla(talla));

        return salida;
    }

    //filtrado por color
    @GetMapping("/color/{color}")
    public ResponseEntity<List<ZapatoDTO>> getCatalogoColor(@PathVariable String color){
        List<ZapatoDTO> zaps = repository.buscarFiltradoColor(color);
        return new ResponseEntity<>(zaps, HttpStatus.OK);
    }

    @GetMapping("/color")
    public Output getCatalogoColor2(@RequestParam("color") String color){
        Output salida = new Output();
        salida.setCodigo("0");
        salida.setMensaje("Peticion procesada con exito");
        salida.setEntidad(repository.buscarFiltradoColor(color));

        return salida;
    }

    //filtrado por precio
    @GetMapping("/precio/{precio}")
    public ResponseEntity<List<ZapatoDTO>> getCatalogoPrecio(@PathVariable Double precio){
        List<ZapatoDTO> zaps = repository.buscarFiltradoPrecio(precio);
        return new ResponseEntity<>(zaps, HttpStatus.OK);
    }

    @GetMapping("/precio")
    public Output getCatalogoPrecio2(@RequestParam("precio") Double precio){
        Output salida = new Output();
        salida.setCodigo("0");
        salida.setMensaje("Peticion procesada con exito");
        salida.setEntidad(repository.buscarFiltradoPrecio(precio));

        return salida;
    }

    //Paginado (Request)
    @RequestMapping("/catalogo_pag")
    public Output getCatalogoPaginado(Pageable pageable){
        
        Output salida = new Output();
        salida.setCodigo("200");
        salida.setMensaje("Busqueda realizada con éxito");
        salida.setEntidad(repository.buscarPaginado(pageable));

        return salida;
    }

    @GetMapping("/todosDTO")
    @ResponseStatus(HttpStatus.OK)
    public List<ZapatoDTO> zapatos(){
        return repository.listarZapatosDTO();
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Zapato>> buscarTodos(@RequestHeader("token") String token){
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
    public ResponseEntity<?> crearZapato(@RequestBody ZapatoDTO zapatoDTO, @RequestHeader("token") String token){
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
