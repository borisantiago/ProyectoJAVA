package com.bit.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.proyecto.modelo.Entrega;

public interface EntregaDao extends JpaRepository<Entrega, Integer> {
    
}
