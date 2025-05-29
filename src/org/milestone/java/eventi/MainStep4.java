package org.milestone.java.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class MainStep4 {

    public static void main(String[] args) throws Exception {
        ProgrammaEventi programma = new ProgrammaEventi("Milestone 3");
        Evento LSI = new Evento("La storia infinita", LocalDate.of(2027, 12, 25), 2000);
        Evento pinocchio = new Evento("Pinocchio", LocalDate.of(2026, 12, 25), 200);
        Evento esame = new Evento("L'esame della milestone", LocalDate.of(2025, 06, 15), 2);

        // Aggiunta eventi nella lista *programma*
        programma.AggiungiEvento(LSI);
        programma.AggiungiEvento(pinocchio);
        programma.AggiungiEvento(esame);

        System.out.println("----------LISTA EVENTI AGGIUNTI----------");
        System.out.println(programma.titolo);
        System.out.println("Programma:");
        for (Evento e : programma.eventi) {
            System.out.println("- " + e);

        }

        // Indicazione degli eventi in una determinata data
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserire la data degli eventi che si vogliono visualizzare: anno..mese..giorno ");
        programma.EventiInData(LocalDate.of(Integer.parseInt(scanner.nextLine()),
                Integer.parseInt(scanner.nextLine()), Integer.parseInt(scanner.nextLine())));

        scanner.close();

        // Indicazione del numeri di eventi caricati
        System.out.println("----------NUMERO DI EVENTI IN PROGRAMMA----------");
        System.out.println(programma.NumeroEventiPresenti());

        // Ordinamento per data
        programma.mettiInOrdine();
        System.out.println("----------LISTA IN ORDINE DI DATA----------");
        System.out.println("Programma:");
        for (Evento e : programma.eventi) {
            System.out.println("- " + e);

        }

        // Svuota lista con prova
        programma.SvuotaLista();

        System.out.println("----------LISTA SVUOTATA----------");
        System.out.println(programma.titolo);
        System.out.println("Programma:");
        for (Evento e : programma.eventi) {
            System.out.println("- " + e);

        }
    }

}
