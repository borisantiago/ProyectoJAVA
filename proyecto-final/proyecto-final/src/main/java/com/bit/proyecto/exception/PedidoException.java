package com.bit.proyecto.exception;

public class PedidoException extends RuntimeException {

    public PedidoException(String mensaje){
        super("error " + mensaje);

    }

}
