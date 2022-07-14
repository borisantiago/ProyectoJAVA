package com.bit.proyecto.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bit.proyecto.dao.EntregaDao;
import com.bit.proyecto.exception.EntregaException;
import com.bit.proyecto.modelo.Entrega;
import com.bit.proyecto.modelo.dto.EntregaDTO;

public class EntregaRepository {
    
    @Autowired
    private EntregaDao repository;

    public List<EntregaDTO> buscarTodos(){
        List<EntregaDTO> dtos = new ArrayList<>();
        for(Entrega p: repository.findAll()){
            dtos.add(this.getDTO(p));
        }
        return dtos;
    } 

    public EntregaDTO buscarUnico(Integer id){
        Entrega Entrega = repository.findById(id).orElseThrow(()-> new EntregaException("no se encontro la Entrega"));
        return this.getDTO(Entrega);
    } 

    public EntregaDTO guardarEntrega(EntregaDTO p){
        Entrega per = repository.save(this.getEntidad(p));
        return this.getDTO(per);
    }

    public void guardarEntrega2(Entrega p){
        repository.save(p);
         
    }

    public List<EntregaDTO> buscarTodos2() {
        return null;
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
        return new EntregaDTO(p.getEntCodigo(), p.getEntDescripcion(), p.getEntRecibe(), p.getEntObservacion(), p.getEntFechaEnvio(), p.getEntEstado(), p.getPedCodigo());
    }

    private Entrega getEntidad(EntregaDTO p){
        return new Entrega(p.getEntCodigo(), p.getEntDescripcion(), p.getEntRecibe(), p.getEntObservacion(), p.getEntFechaEnvio(), p.getEntEstado(), p.getPedCodigo());
    }

}
