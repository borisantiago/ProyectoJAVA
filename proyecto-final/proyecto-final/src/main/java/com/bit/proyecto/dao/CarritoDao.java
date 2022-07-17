package com.bit.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.proyecto.modelo.Carrito;

public interface CarritoDao extends JpaRepository<Carrito, Integer> {
    
}
