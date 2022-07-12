package com.bit.proyecto.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.proyecto.dao.PersonaDao;
import com.bit.proyecto.modelo.Persona;

@Repository
public class PersonaRepository {

    @Autowired
    private PersonaDao personaDao;

    public List<Persona> buscarTodos(){
        return (List<Persona>) personaDao.findAll();
    } 


    public void guardarPersona(Persona persona) throws Exception{

            personaDao.save(persona);
        }
    
    
    // public void eliminarPersona(Integer id){
    //     personaDao.deleteById(id.toString());
    // }
    
}
