package com.bit.proyecto.exception;

public class ZapatoException extends RuntimeException {

    public ZapatoException(String mensaje){
        super("eror " + mensaje);
    }

}
