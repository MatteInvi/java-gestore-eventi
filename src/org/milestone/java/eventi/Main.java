package org.milestone.java.eventi;

public class Main {
    public static void main(String[] args) throws Exception {

        // Inserimento dati evento
        System.out.println("Inserimento di un nuovo evento prenotazione e disdetta posti: ");
        CreazioneEvento.main(args);

        System.out.println("______________________________________________________");
        System.out.println("Richieste step 4: ");
        // Step4 con vari metodi ed eventi pre-creati
        MainStep4.main(args);
    }
}
