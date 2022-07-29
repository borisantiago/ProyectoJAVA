package com.bit.proyecto.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.proyecto.dao.EntregaDao;
import com.bit.proyecto.exception.EntregaException;
import com.bit.proyecto.modelo.Entrega;
import com.bit.proyecto.modelo.dto.EntregaDTO;

@Repository
public class EntregaRepository {
    
    @Autowired
    private EntregaDao repository;

    public List<EntregaDTO> buscarTodos2(){
        List<EntregaDTO> dtos = new ArrayList<>();
        for(Entrega p: repository.findAll()){
            dtos.add(this.getDTO(p));
        }
        return dtos;
    } 

    public List<Entrega> buscarTodos(){
        return (List<Entrega>) repository.findAll();
    }

    public EntregaDTO buscarUnicoDTO(Integer id){
        Entrega Entrega = repository.findById(id).orElseThrow(()-> new EntregaException("no se encontro la Entrega"));
        return this.getDTO(Entrega);
    } 

    public Entrega buscarUnico(Integer id){
        Entrega entrega = repository.findById(id).orElseThrow(()-> new EntregaException("no se encontro la Entrega"));
        return entrega;
    } 

    public EntregaDTO guardarEntrega(EntregaDTO p){
        Entrega per = repository.save(this.getEntidad(p));
        return this.getDTO(per);
    }

    public EntregaDTO actualizarEntrega(EntregaDTO p){
        Entrega per = repository.findById(p.getPedCodigo()).orElseThrow(()-> new EntregaException("Entrega no encontrada"));
        repository.save(this.getEntidad(p));
        return this.getDTO(per);
    }

    public void eliminarEntrega(Integer id){
        repository.findById(id).orElseThrow(()-> new EntregaException("no se encontro la peronsa con codigo"));
        repository.deleteById(id);
    }


    private EntregaDTO getDTO(Entrega p){
        return new EntregaDTO(p.getEntCodigo(), p.getEntDescripcion(), p.getEntRecibe(), p.getEntObservacion(), p.getEntEstado(), p.getPedCodigo());
    }

    private Entrega getEntidad(EntregaDTO p){
        return new Entrega(p.getEntCodigo(), p.getEntDescripcion(), p.getEntRecibe(), p.getEntObservacion(), p.getEntEstado(), p.getPedCodigo());
    }

}
