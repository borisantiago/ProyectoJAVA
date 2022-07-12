package com.bit.proyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bit.proyecto.modelo.dto.ZapatoDTO;
import com.bit.proyecto.servicio.ZapatoRepository;

@RestController
@RequestMapping("/zapatos")
public class ZapatoController {
    
    @Autowired
    private ZapatoRepository respository;

    @GetMapping("/todos")
    @ResponseStatus(HttpStatus.OK)
    public List<ZapatoDTO> zapatos(){
        return respository.listarZapatos();
    }
}
