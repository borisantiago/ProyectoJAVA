package com.bit.proyecto.exception;

public class CarritoException extends RuntimeException{
    
    public CarritoException(String mensaje){
        super("error " + mensaje);
    }
}
