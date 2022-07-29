package com.bit.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.proyecto.modelo.Zapato;

public interface ZapatoDao extends JpaRepository<Zapato, String> {
    
}
