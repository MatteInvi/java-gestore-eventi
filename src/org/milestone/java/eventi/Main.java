package org.milestone.java.eventi;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.zip.DataFormatException;

public class Main {
    public static void main(String[] args) throws Exception{

   Evento mioEvento = new Evento("La mia storia", LocalDate.of(2110, 05, 19), 200);
System.out.println(mioEvento);


       mioEvento.prenota(199);
       mioEvento.prenota(1);

        
       mioEvento.disdici(19);

     System.out.println(mioEvento);
//     LocalDate data = LocalDate.now();
//     System.out.println(data);

    }
}
