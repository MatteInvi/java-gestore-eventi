package org.milestone.java.eventi;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        String risposta;
        int postiRimanenti = 0;
        String tipoEvento;



        Scanner scanner = new Scanner(System.in);
        // Richiesta del tipo di evento (evento/concerto)

        System.out.println("Che tipo di evento vuoi creare? (evento o concerto)");
        tipoEvento = scanner.nextLine();

        // Creazione nuovo evento/concerto
        System.out.println("Inserisci il titolo: ");
        String titolo = scanner.nextLine();
        System.out.println("Inserisci il giorno: ");
        int giornoEvento = Integer.parseInt(scanner.nextLine());
        System.out.println("Inserisci il mese: ");
        int meseEvento = Integer.parseInt(scanner.nextLine());
        System.out.println("Inserisci l'anno: ");
        int annoEvento = Integer.parseInt(scanner.nextLine());
        System.out.println("Inserisci i posti totali: ");
        int postiTotali = Integer.parseInt(scanner.nextLine());
        if (tipoEvento.equals("concerto")) {
            System.out.println("Inserisci l'ora (da 0 a 23): ");
            int oraEvento = Integer.parseInt(scanner.nextLine());
            System.out.println("Inserisci i minuti (da 0 a 59): ");
            int minutoEvento = Integer.parseInt(scanner.nextLine());
            System.out.println("Inserisci il prezzo: ");
            Float prezzo = Float.parseFloat(scanner.nextLine());
            Concerto nuovoEvento = new Concerto(LocalTime.of(oraEvento, minutoEvento), prezzo, titolo,
                    LocalDate.of(annoEvento, meseEvento, giornoEvento), postiTotali);


            // Richieste di prenotazioni

          System.out.println("Vuoi prenotare dei posti? si/no");
            risposta = scanner.nextLine();

            while (risposta.equals("si")) {

                System.out.println("Quanti posti vuoi prenotare?");
                int nPostiDaAggiungere = Integer.parseInt(scanner.nextLine());
                nuovoEvento.prenota(nPostiDaAggiungere);
                postiRimanenti = nuovoEvento.getNPostiTotali() - nuovoEvento.getNPostiPrenotati();
                System.out.println("Vuoi prenotare altri posti? si/no");
                risposta = scanner.nextLine();

            }

            System.out.println("I posti prenotati sono: " + nuovoEvento.getNPostiPrenotati());
            System.out
                    .println("I posti rimanenti sono: " + postiRimanenti);

            // Richieste di disdette
            System.out.println("Vuoi disdire delle prenotazioni? (si/no)");
            risposta = scanner.nextLine();

            while (risposta.equals("si")) {

                System.out.println("Quanti posti vuoi disdire?");
                int nPostiDaTogliere = Integer.parseInt(scanner.nextLine());
                nuovoEvento.disdici(nPostiDaTogliere);
                postiRimanenti = (nuovoEvento.getNPostiTotali() - nuovoEvento.getNPostiPrenotati());
                System.out.println("Vuoi disdire altre prenotazioni? (si/no)");
                risposta = scanner.nextLine();

            }

            System.out.println("I posti prenotati sono: " + nuovoEvento.getNPostiPrenotati());
            System.out
                    .println("I posti rimanenti sono: " + postiRimanenti);

            System.out.println(nuovoEvento);

        } else {
            Evento nuovoEvento = new Evento(titolo, LocalDate.of(annoEvento, meseEvento, giornoEvento),
                    postiTotali);
            // Richieste di prenotazioni

            System.out.println("Vuoi prenotare dei posti? si/no");
            risposta = scanner.nextLine();

            while (risposta.equals("si")) {

                System.out.println("Quanti posti vuoi prenotare?");
                int nPostiDaAggiungere = Integer.parseInt(scanner.nextLine());
                nuovoEvento.prenota(nPostiDaAggiungere);
                postiRimanenti = nuovoEvento.getNPostiTotali() - nuovoEvento.getNPostiPrenotati();
                System.out.println("Vuoi prenotare altri posti? si/no");
                risposta = scanner.nextLine();

            }

            System.out.println("I posti prenotati sono: " + nuovoEvento.getNPostiPrenotati());
            System.out
                    .println("I posti rimanenti sono: " + postiRimanenti);

            // Richieste di disdette
            System.out.println("Vuoi disdire delle prenotazioni? (si/no)");
            risposta = scanner.nextLine();

            while (risposta.equals("si")) {

                System.out.println("Quanti posti vuoi disdire?");
                int nPostiDaTogliere = Integer.parseInt(scanner.nextLine());
                nuovoEvento.disdici(nPostiDaTogliere);
                postiRimanenti = (nuovoEvento.getNPostiTotali() - nuovoEvento.getNPostiPrenotati());
                System.out.println("Vuoi disdire altre prenotazioni? (si/no)");
                risposta = scanner.nextLine();

            }

            System.out.println("I posti prenotati sono: " + nuovoEvento.getNPostiPrenotati());
            System.out
                    .println("I posti rimanenti sono: " + postiRimanenti);

            System.out.println(nuovoEvento);
        }
    

        scanner.close();

    }

}
