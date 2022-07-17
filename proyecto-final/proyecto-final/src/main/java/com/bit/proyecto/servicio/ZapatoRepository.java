package com.bit.proyecto.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.bit.proyecto.dao.ZapatoDao;
import com.bit.proyecto.exception.ZapatoException;
import com.bit.proyecto.modelo.Zapato;
import com.bit.proyecto.modelo.dto.ZapatoDTO;

@Repository
public class ZapatoRepository {

    @Autowired
    private ZapatoDao repository;


    //Filtrar por genero
    public List<ZapatoDTO> buscarFiltrado(String genero){
        ZapatoDTO plantilla = new ZapatoDTO();
        plantilla.setZapGenero(genero);
        Zapato pla = this.getEntidad(plantilla);
        List<ZapatoDTO> dtos = new ArrayList<>();
        for(Zapato z: repository.findAll(Example.of(pla))){
                dtos.add(this.getDTO(z));
        }
        return dtos;
    }

    //Filtrar por genero
    public List<ZapatoDTO> buscarFiltradoTalla(String talla){
        ZapatoDTO plantilla = new ZapatoDTO();
        plantilla.setZapTalla(talla);
        Zapato pla = this.getEntidad(plantilla);
        List<ZapatoDTO> dtos = new ArrayList<>();
        for(Zapato z: repository.findAll(Example.of(pla))){
                dtos.add(this.getDTO(z));
        }
        return dtos;
    }

    //Filtrar por color
    public List<ZapatoDTO> buscarFiltradoColor(String color){
        ZapatoDTO plantilla = new ZapatoDTO();
        plantilla.setZapColor(color);
        Zapato pla = this.getEntidad(plantilla);
        List<ZapatoDTO> dtos = new ArrayList<>();
        for(Zapato z: repository.findAll(Example.of(pla))){
                dtos.add(this.getDTO(z));
        }
        return dtos;
    }

    //Filtrar por precio
    public List<ZapatoDTO> buscarFiltradoPrecio(Double precio){
        ZapatoDTO plantilla = new ZapatoDTO();
        plantilla.setZapPrecio(precio);
        Zapato pla = this.getEntidad(plantilla);
        List<ZapatoDTO> dtos = new ArrayList<>();
        for(Zapato z: repository.findAll(Example.of(pla))){
                dtos.add(this.getDTO(z));
        }
        return dtos;
    }
    
    //paginar
    public List<ZapatoDTO> buscarPaginado(Pageable pageable){
        List<ZapatoDTO> dtos = new ArrayList<>();
        for(Zapato z: repository.findAll(pageable)){
            dtos.add(this.getDTO(z));
        }
        return dtos;
    }


    public List<ZapatoDTO> listarZapatosDTO(){
        List<ZapatoDTO> dtos = new ArrayList<>();
        for(Zapato z: repository.findAll()){
            dtos.add(new ZapatoDTO(z.getZapCodigo(), z.getZapNombre(), z.getZapModelo(), z.getZapGenero(), z.getZapColor(), z.getZapTalla(), z.getZapStock(), z.getZapPrecio()));
        }
        return  dtos;
    }

    public List<Zapato> todosZapatos(){
        return (List<Zapato>) repository.findAll();
    }

    public ZapatoDTO buscarUnicoDTO(String id){
        Zapato per = repository.findById(id).orElseThrow(()-> new ZapatoException(" no se encontro la Zapato"));
        return this.getDTO(per);
    } 

    public Zapato buscarunico(String id){
        Zapato zap = repository.findById(id).orElseThrow(()-> new ZapatoException("No se encontro el zapato con el id"+ id));
        return zap;
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
