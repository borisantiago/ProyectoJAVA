package com.bit.proyecto.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.proyecto.dao.ZapatoDao;
import com.bit.proyecto.exception.ZapatoException;
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

    public ZapatoDTO buscarUnico(String id){
        Zapato per = repository.findById(id).orElseThrow(()-> new ZapatoException(" no se encontro la Zapato"));
        return this.getDTO(per);
    } 

    public ZapatoDTO guardarZapato(ZapatoDTO p){
        Zapato per = repository.save(this.getEntidad(p));
        return this.getDTO(per);
    }

    public ZapatoDTO actualizarZapato(ZapatoDTO p){
        Zapato per = repository.findById(p.getZapCodigo()).orElseThrow(()-> new ZapatoException(" Zapato no encontrada"));
        repository.save(this.getEntidad(p));
        return this.getDTO(per);
    }

    public void eliminarZapato(String id){
        repository.findById(id).orElseThrow(()-> new ZapatoException(" no se encontro la peronsa con codigo"));
        repository.deleteById(id);
    }
    




    private ZapatoDTO getDTO(Zapato z){
        return new ZapatoDTO(z.getZapCodigo(), z.getZapNombre(), z.getZapModelo(), z.getZapGenero(), z.getZapColor(), 
            z.getZapTalla(), z.getZapStock(), z.getZapPrecio());
    }

    private Zapato getEntidad(ZapatoDTO z){
        return new Zapato(z.getZapCodigo(), z.getZapNombre(), z.getZapModelo(), z.getZapGenero(), z.getZapColor(), 
            z.getZapTalla(), z.getZapStock(), z.getZapPrecio());
    }


    
}
