package com.bit.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.proyecto.modelo.DetallePedido;

public interface DetallePedidoDao extends JpaRepository<DetallePedido, String>{
    
}
