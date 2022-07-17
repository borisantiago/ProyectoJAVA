package com.bit.proyecto.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import com.bit.proyecto.dao.PedidoDao;
import com.bit.proyecto.exception.PedidoException;
import com.bit.proyecto.modelo.Pedido;
import com.bit.proyecto.modelo.dto.PedidoDTO;

@Repository
public class PedidoRepository {
    
    @Autowired
    private PedidoDao repository;

    //pedidos de cliente
    public List<PedidoDTO> pedidosPorIdCliente(Integer id){
        PedidoDTO plantilla = new PedidoDTO();
        plantilla.setPerCodigo(id);
        Pedido planti = this.getEntidad(plantilla);
        List<PedidoDTO> dtos = new ArrayList<>();
        for(Pedido p : repository.findAll(Example.of(planti))){
            dtos.add(this.getDTO(p));
        }
        return dtos;
    }

    public List<PedidoDTO> buscarTodos2(){
        List<PedidoDTO> dtos = new ArrayList<>();
        for(Pedido p: repository.findAll()){
            dtos.add(this.getDTO(p));
        }
        return dtos;
    } 

    public List<Pedido> buscarTodos(){
        return (List<Pedido>) repository.findAll();
    }

    public PedidoDTO buscarUnico(Integer id){
        Pedido pedido = repository.findById(id).orElseThrow(()-> new PedidoException("no se encontro la Pedido"));
        return this.getDTO(pedido);
    } 

    public PedidoDTO guardarPedido(PedidoDTO p){
        p.setPedEstado("Gestionando");
        Pedido per = repository.save(this.getEntidad(p));
        return this.getDTO(per);
    }

    public void guardarPedido2(Pedido p){
        repository.save(p);
         
    }
    

    public PedidoDTO actualizarPedido(PedidoDTO p){
        Pedido per = repository.findById(p.getPedCodigo()).orElseThrow(()-> new PedidoException("Pedido no encontrada"));
        repository.save(this.getEntidad(p));
        return this.getDTO(per);
    }

    public void eliminarPedido(Integer id){
        repository.findById(id).orElseThrow(()-> new PedidoException("no se encontro la peronsa con codigo"));
        repository.deleteById(id);
    }


    private PedidoDTO getDTO(Pedido p){
        return new PedidoDTO(p.getPedCodigo(), p.getPedFecha(), p.getPedObservacion(), p.getPedEstado(), p.getPedSubtotal(), 
                p.getPedFactura(), p.getPedIva(), p.getPerCodigo());
    }

    private Pedido getEntidad(PedidoDTO p){
        return new Pedido(p.getPedCodigo(), p.getPedFecha(), p.getPedObservacion(), p.getPedEstado(), p.getPedSubtotal(), 
        p.getPedFactura(), p.getPedIva(), p.getPerCodigo());
    }





}
