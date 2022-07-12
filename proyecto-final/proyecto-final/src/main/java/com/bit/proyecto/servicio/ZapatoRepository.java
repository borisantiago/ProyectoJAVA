package com.bit.proyecto.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.proyecto.dao.ZapatoDao;
import com.bit.proyecto.modelo.Zapato;
import com.bit.proyecto.modelo.dto.ZapatoDTO;

@Repository
public class ZapatoRepository {

    @Autowired
    private ZapatoDao repository;

    public List<ZapatoDTO> listarZapatos(){
        List<ZapatoDTO> dtos = new ArrayList<>();
        for(Zapato z: repository.findAll()){
            dtos.add(new ZapatoDTO(z.getZapCodigo(), z.getZapNombre(), z.getZapModelo(), z.getZapGenero(), z.getZapColor(), z.getZapTalla(), z.getZapStock(), z.getZapPrecio()));
        }
        return  dtos;
    }
    
}
