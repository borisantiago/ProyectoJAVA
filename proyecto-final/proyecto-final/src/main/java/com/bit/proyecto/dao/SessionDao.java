package com.bit.proyecto.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.proyecto.modelo.Session;

public interface SessionDao extends JpaRepository<Session, Long> {
    List<Session> findAllByUsuarioSession(String usuarioSession);

    Optional<Session> findByUsuarioSession(String usuarioSession);
}
