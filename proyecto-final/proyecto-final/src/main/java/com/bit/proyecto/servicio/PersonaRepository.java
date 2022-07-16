package com.bit.proyecto.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.proyecto.dao.PersonaDao;
import com.bit.proyecto.exception.PersonaException;
import com.bit.proyecto.modelo.Persona;
import com.bit.proyecto.modelo.dto.PersonaDTO;

@Repository
public class PersonaRepository {

    @Autowired
    private PersonaDao repository;

    public List<PersonaDTO> buscarTodos2(){
        List<PersonaDTO> dtos = new ArrayList<>();
        for(Persona p: repository.findAll()){
            dtos.add(this.getDTO(p));
        }
        return dtos;
    } 

    public List<Persona> buscarTodos(){
        return (List<Persona>) repository.findAll();
    }

    public Persona buscarUnico(Integer id){
        Persona per = repository.findById(id).orElseThrow(()-> new PersonaException("no se encontro la persona"));
        return per;
    } 

    public PersonaDTO buscarUnicoDTO(Integer id){
        Persona per = repository.findById(id).orElseThrow(()-> new PersonaException("no se encontro la persona"));
        return this.getDTO(per);
    } 

    

    public PersonaDTO guardarPersona(PersonaDTO p){
        Persona per = repository.save(this.getEntidad(p));
        return this.getDTO(per);
    }

    public void guardarPersona2(Persona p){
        repository.save(p);
    }

    public PersonaDTO actualizarPersona(PersonaDTO p){
        Persona per = repository.findById(p.getPerCodigo()).orElseThrow(()-> new PersonaException("persona no encontrada"));
        repository.save(this.getEntidad(p));
        return this.getDTO(per);
    }

    public void eliminarPersona(Integer id){
        repository.findById(id).orElseThrow(()-> new PersonaException("no se encontro la peronsa con codigo"));
        repository.deleteById(id);
    }
    

    private PersonaDTO getDTO(Persona p){
        return new PersonaDTO(p.getPerCodigo(), p.getPerIdentificacion(), p.getPerNombre(), p.getPerApellido(), p.getPerDireccion(), 
        p.getPerTalla(), p.getPerFechaNacimiento(), p.getPerGenero(), p.getPerEmail());
    }

    private Persona getEntidad(PersonaDTO p){
        return new Persona(p.getPerCodigo(), p.getPerIdentificacion(), p.getPerNombre(), p.getPerApellido(), p.getPerDireccion(), 
            p.getPerTalla(), p.getPerFechaNacimiento(), p.getPerGenero(), p.getPerEmail());
    }


}
