package com.cadernodecampo.springcadernodecampo.Exceptions;

public class DataIntegrityViolation extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DataIntegrityViolation(String message, Throwable cause){
        super(message,cause);
    }
    public DataIntegrityViolation(String message){
        super(message);
    }
}
