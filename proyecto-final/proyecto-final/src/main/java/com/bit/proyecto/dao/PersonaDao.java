package com.bit.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.bit.proyecto.modelo.Persona;

public interface PersonaDao extends JpaRepository<Persona, String> {

      
}
