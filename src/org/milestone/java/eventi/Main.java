package org.milestone.java.eventi;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import org.milestone.java.eventi.exceptions.ExceptionDataPassata;
import org.milestone.java.eventi.exceptions.ExceptionNessunaPrenotazione;
import org.milestone.java.eventi.exceptions.ExceptionNumeroNonValido;
import org.milestone.java.eventi.exceptions.ExceptionPostiEsauriti;

public class Main {
    public static void main(String[] args) throws Exception {
    
        String risposta;
        int postiRimanenti = 0;
        // Evento nuovoConcerto = null; 
        Evento nuovoEvento = null;
        String tipoEvento = "";

        Scanner scanner = new Scanner(System.in);

    // Creazione nuovo evento/concerto
try {   System.out.println("Inserisci il titolo: ");
        String titolo = scanner.nextLine();
        System.out.println("Inserisci il giorno: ");
        int giornoEvento = Integer.parseInt(scanner.nextLine());
        System.out.println("Inserisci il mese: ");
        int meseEvento = Integer.parseInt(scanner.nextLine());
        System.out.println("Inserisci l'anno: ");
        int annoEvento = Integer.parseInt(scanner.nextLine());
        System.out.println("Inserisci i posti totali: ");
        int postiTotali = Integer.parseInt(scanner.nextLine());
        System.out.println("Questo evento è un concerto? (si/no)");
        tipoEvento = scanner.nextLine().toLowerCase();
        if (tipoEvento.equals("si")) {
            System.out.println("---------STAI AGGIUNGENDO UN CONCERTO-----------");
            System.out.println("Inserisci l'ora (da 0 a 23): ");
            int oraEvento = Integer.parseInt(scanner.nextLine());
            System.out.println("Inserisci i minuti (da 0 a 59): ");
            int minutoEvento = Integer.parseInt(scanner.nextLine());
            System.out.println("Inserisci il prezzo: ");
            Float prezzo = Float.parseFloat(scanner.nextLine());

        // Creazione evento di tipo concerto
            nuovoEvento = new Concerto(LocalTime.of(oraEvento, minutoEvento), prezzo, titolo,
                    LocalDate.of(annoEvento, meseEvento, giornoEvento), postiTotali);

        // Creazione evento generico
        } else {
            nuovoEvento = new Evento(titolo, LocalDate.of(annoEvento, meseEvento, giornoEvento),
                    postiTotali);

        } 

    // Blocco richieste prenotazioni/disdette

 
        // Richieste di prenotazioni evento generico
            System.out.println("Vuoi prenotare dei posti? si/no");
            risposta = scanner.nextLine().toLowerCase();

            while (risposta.equals("si")) {

                System.out.println("Quanti posti vuoi prenotare?");
                int nPostiDaAggiungere = Integer.parseInt(scanner.nextLine());
                nuovoEvento.prenota(nPostiDaAggiungere);
                postiRimanenti = nuovoEvento.getNPostiTotali() - nuovoEvento.getNPostiPrenotati();
                System.out.println("Vuoi prenotare altri posti? si/no");
                risposta = scanner.nextLine().toLowerCase();

            }

        //Stampa posti prenotati e rimanenti
            System.out.println("I posti prenotati sono: " + nuovoEvento.getNPostiPrenotati());
            System.out
                    .println("I posti rimanenti sono: " + postiRimanenti);

        // Richieste di disdette evento generico
            System.out.println("Vuoi disdire delle prenotazioni? (si/no)");
            risposta = scanner.nextLine().toLowerCase();

            while (risposta.equals("si")) {

                System.out.println("Quanti posti vuoi disdire?");
                int nPostiDaTogliere = Integer.parseInt(scanner.nextLine());
                nuovoEvento.disdici(nPostiDaTogliere);
                postiRimanenti = (nuovoEvento.getNPostiTotali() - nuovoEvento.getNPostiPrenotati());
                System.out.println("Vuoi disdire altre prenotazioni? (si/no)");
                risposta = scanner.nextLine().toLowerCase();

            }


        //Stampa posti prenotati e rimanenti
            System.out.println("I posti prenotati sono: " + nuovoEvento.getNPostiPrenotati());
            System.out
                    .println("I posti rimanenti sono: " + postiRimanenti);
            

        // Stampa evento creato            
            System.out.println(nuovoEvento);


    } catch (ExceptionNessunaPrenotazione noReservations){
        System.err.println(noReservations.getMessage());
    } catch (ExceptionNumeroNonValido invalidN ){
        System.err.println(invalidN.getMessage());
    } catch (ExceptionPostiEsauriti soldOut){
        System.err.println(soldOut.getMessage());
    } catch (ExceptionDataPassata pastDate){
        System.err.println(pastDate.getMessage());
    }

        scanner.close();

    }

}
