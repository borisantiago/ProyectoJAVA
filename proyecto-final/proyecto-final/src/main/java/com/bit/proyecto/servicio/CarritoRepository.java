package com.bit.proyecto.servicio;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import com.bit.proyecto.dao.CarritoDao;
import com.bit.proyecto.exception.CarritoException;
import com.bit.proyecto.modelo.Carrito;

@Repository
public class CarritoRepository {
    
    @Autowired
    private CarritoDao repository;

    public List<Carrito> buscarZapatosEnCarrito(Integer idPersona){
        Carrito carr = new Carrito();
        carr.setPerCodigo(idPersona);
        List<Carrito> dtos = new ArrayList<>();
        for(Carrito c: repository.findAll(Example.of(carr))){
            dtos.add(c);
        }
        return dtos;
    }

    public List<Carrito> buscarTodos(){
        return (List<Carrito>) repository.findAll();
    }

    public Carrito buscarUnico(Integer id){
        Carrito car = repository.findById(id).orElseThrow(()-> new CarritoException("no se encontro la Carrito"));
        return car;
    } 

    public void guardarCarrito(Carrito c){
        repository.save(c);
    }

    public Carrito actualizarCarrito(Carrito p){
        Carrito per = repository.findById(p.getCarCodigo()).orElseThrow(()-> new CarritoException("Carrito no encontrada"));
        return repository.save(per);
    }

    public void eliminarCarrito(Integer id){
        repository.deleteById(id);
    }




}
