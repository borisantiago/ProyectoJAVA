package com.bit.proyecto.exception;

public class DetallePedidoException extends RuntimeException{

    public DetallePedidoException(String mensaje){
        super("error " + mensaje);
    }

}
