package org.milestone.java.eventi.exceptions;

public class ExceptionNessunaPrenotazione  extends Exception{
// Eccezzione in caso di prenotazioni non presenti
    public ExceptionNessunaPrenotazione(String message){
        super(message);
    }
    
}
