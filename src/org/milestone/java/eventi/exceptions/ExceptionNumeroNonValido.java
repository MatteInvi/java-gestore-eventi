package org.milestone.java.eventi.exceptions;

public class ExceptionNumeroNonValido extends Exception  {
    // Eccezzione per numeri inferiori a 1
    public ExceptionNumeroNonValido(String message){
        super(message);
    }
}