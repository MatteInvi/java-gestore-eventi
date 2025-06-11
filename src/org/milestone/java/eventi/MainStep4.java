package org.milestone.java.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class MainStep4 {

    public static void main(String[] args) throws Exception {
        ProgrammaEventi programma = new ProgrammaEventi("Milestone 3");
        Evento LSI = new Evento("La storia infinita", LocalDate.of(2025, 6, 22), 2000);
        Evento pinocchio = new Evento("Pinocchio", LocalDate.of(2026, 12, 25), 400);
        Evento NSLS = new Evento("Notte sotto le stelle", LocalDate.of(2025, 6, 22), 2000);
        Evento Capdanno = new Evento("Capdonaddo in piazza", LocalDate.of(2025, 12, 31), 20000);
        Evento Fine = new Evento("Fine del mondo", LocalDate.of(2030, 12, 21), 1);

        Scanner scanner = new Scanner(System.in);

    // Aggiunta eventi nella lista *programma* con stampa su terminale
        programma.aggiungiEvento(LSI);
        programma.aggiungiEvento(pinocchio);
        programma.aggiungiEvento(NSLS);
        programma.aggiungiEvento(Capdanno);
        programma.aggiungiEvento(Fine);

        System.out.println("----------LISTA EVENTI AGGIUNTI----------");
        System.out.println(programma.titolo);
        System.out.println("Programma:");
        for (Evento e : programma.eventi) {
            System.out.println("- " + e);

        }

        scanner.nextLine();

    // Indicazione degli eventi in una determinata data

        System.out.println("Inserire la data degli eventi che si vogliono visualizzare: ");
        System.out.println("Giorno: ");
        int giorno = Integer.parseInt(scanner.nextLine());
        System.out.println("Mese: ");
        int mese = Integer.parseInt(scanner.nextLine());
        System.out.println("Anno:");
        int anno = Integer.parseInt(scanner.nextLine());

        programma.eventiInData(LocalDate.of(anno, mese, giorno));

        scanner.nextLine();

    // Indicazione del numeri di eventi caricati
        System.out.println("----------NUMERO DI EVENTI IN PROGRAMMA----------");

        System.out.println(programma.numeroEventiPresenti());

        scanner.nextLine();

    // Ordinamento per data
        programma.mettiInOrdine();
        System.out.println("----------LISTA IN ORDINE DI DATA----------");
        System.out.println("Programma:");
        for (Evento e : programma.eventi) {
            System.out.println("- " + e);

        }

        scanner.nextLine();

    // Svuota lista con prova
        programma.svuotaLista();

        System.out.println("----------LISTA SVUOTATA----------");
        System.out.println(programma.titolo);
        System.out.println("Programma:");
        for (Evento e : programma.eventi) {
            System.out.println("- " + e);

        }

        scanner.close();
    }

}
