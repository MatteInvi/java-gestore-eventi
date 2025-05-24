package org.milestone.java.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        String risposta;
        int nPostiDaAggiungere = 0;

        Evento mioEvento = new Evento("La mia storia", LocalDate.of(2110, 05, 19), 200);

        Scanner scanner = new Scanner(System.in);

// Richieste di prenotazioni
        System.out.println("Vuoi prenotare dei posti? si/no");
        risposta = scanner.nextLine();

        while (risposta.equals("si")) {

            System.out.println("QUanti posti vuoi prenotare?");
            nPostiDaAggiungere = Integer.parseInt(scanner.nextLine());
            mioEvento.prenota(nPostiDaAggiungere);
            System.out.println("Vuoi prenotare dei posti? si/no");
            risposta = scanner.nextLine();

        }

        System.out.println("I posti prenotati sono: " + mioEvento.getNPostiPrenotati());
        System.out.println(("I posti rimanenti sono: " + (mioEvento.getNPostiTotali() - mioEvento.getNPostiPrenotati())));

        System.out.println("Vuoi disdire delle prenotazioni?");
        risposta = scanner.nextLine();

// Richieste di disdette
        while (risposta.equals("si")) {

            System.out.println("Inserire il numero di posti da disdire");
            int nPostiDaTogliere = Integer.parseInt(scanner.nextLine());
            mioEvento.disdici(nPostiDaTogliere);
            System.out.println("Vuoi disdire delle prenotazioni?");
            risposta = scanner.nextLine();

        }

        System.out.println("I posti prenotati sono: " + mioEvento.getNPostiPrenotati());
        System.out.println(("I posti rimanenti sono: " + (mioEvento.getNPostiTotali() - mioEvento.getNPostiPrenotati())));

        scanner.close();

        // mioEvento.prenota(199);
        // mioEvento.prenota(1);

        // mioEvento.disdici(19);

        System.out.println(mioEvento);
        // LocalDate data = LocalDate.now();
        // System.out.println(data);

    }
}
