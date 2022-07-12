package com.bit.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.proyecto.modelo.Pedido;

public interface PedidoDao extends JpaRepository<Pedido, String> {
    
}
