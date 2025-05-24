package org.milestone.java.eventi;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception{

   Evento mioEvento = new Evento("La mia storia", LocalDate.of(2010, 05, 19), 200);
System.out.println(mioEvento);


    try {
       mioEvento.prenota(210);
    } catch (Exception posti){
        System.out.println("Non ci sono posti disponibili");
    } 
        
//    mioEvento.disdici(1);

     System.out.println(mioEvento);
//     LocalDate data = LocalDate.now();
//     System.out.println(data);

    }
}
