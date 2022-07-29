package com.bit.proyecto.exception;

public class PersonaException extends RuntimeException {

    public PersonaException (String mensaje){
        super("error " + mensaje);
    }

}
