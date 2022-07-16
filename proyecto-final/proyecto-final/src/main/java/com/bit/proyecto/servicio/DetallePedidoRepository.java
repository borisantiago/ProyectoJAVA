package com.bit.proyecto.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.proyecto.dao.DetallePedidoDao;
import com.bit.proyecto.exception.DetallePedidoException;
import com.bit.proyecto.modelo.DetallePedido;
import com.bit.proyecto.modelo.dto.DetallePedidoDTO;

@Repository
public class DetallePedidoRepository {

    @Autowired
    private DetallePedidoDao repository;

    public List<DetallePedidoDTO> buscarTodosDTO(){
        List<DetallePedidoDTO> dtos = new ArrayList<>();
        for(DetallePedido p: repository.findAll()){
            dtos.add(this.getDTO(p));
        }
        return dtos;
    } 

    public List<DetallePedido> buscarTodos(){
        return (List<DetallePedido>) repository.findAll();
    }

    public DetallePedido buscarUnico(Integer id){
        DetallePedido per = repository.findById(id).orElseThrow(()-> new DetallePedidoException("no se encontro la DetallePedido"));
        return per;
    } 

    public DetallePedidoDTO buscarUnicoDTO(Integer id){
        DetallePedido per = repository.findById(id).orElseThrow(()-> new DetallePedidoException("no se encontro la DetallePedido"));
        return this.getDTO(per);
    } 

    public DetallePedidoDTO guardarDetallePedido(DetallePedidoDTO p){
        DetallePedido per = repository.save(this.getEntidad(p));
        return this.getDTO(per);
    }

    public void guardarDetallePedido2(DetallePedido p){
        repository.save(p);
    }

    public DetallePedidoDTO actualizarDetallePedido(DetallePedidoDTO p){
        DetallePedido per = repository.findById(p.getDepCodigo()).orElseThrow(()-> new DetallePedidoException("DetallePedido no encontrada"));
        repository.save(this.getEntidad(p));
        return this.getDTO(per);
    }

    public void eliminarDetallePedido(Integer id){
        repository.findById(id).orElseThrow(()-> new DetallePedidoException("no se encontro la peronsa con codigo"));
        repository.deleteById(id);
    }
    

    private DetallePedidoDTO getDTO(DetallePedido p){
        return new DetallePedidoDTO(p.getDepCodigo(), p.getDepCantidad(), p.getDepPrecio(), p.getDepDescuento(), p.getDepIva(), p.getDepSubtotal(), p.getDepObservacion(), p.getPedCodigo(), p.getZapCodigo());
    }

    private DetallePedido getEntidad(DetallePedidoDTO p){
        
        Double cantPre = (p.getDepCantidad() * p.getDepPrecio());
        Double descuneto = cantPre * p.getDepDescuento()/100;
        Double cantPreDesc = cantPre - descuneto; 
        Double iva = cantPreDesc * (p.getDepIva()/100);
        Double subT = cantPreDesc + iva;
        
        return new DetallePedido(p.getDepCodigo(), p.getDepCantidad(), p.getDepPrecio(), p.getDepDescuento(), p.getDepIva(), subT, p.getDepObservacion(), p.getPedCodigo(), p.getZapCodigo());
    }


}
