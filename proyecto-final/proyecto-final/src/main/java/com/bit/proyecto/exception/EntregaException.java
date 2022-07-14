package com.bit.proyecto.exception;

public class EntregaException extends RuntimeException{

    public EntregaException(String mensaje){
        super("error " + mensaje);
    }
}
