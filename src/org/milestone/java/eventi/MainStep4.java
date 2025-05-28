package org.milestone.java.eventi;

import java.time.LocalDate;

public class MainStep4 {

    public static void main(String[] args) throws Exception {
        ProgrammaEventi programma = new ProgrammaEventi("Milestone 3");
        Evento primo = new Evento("La storia infinita", LocalDate.of(2027, 12, 25), 2000);
        Evento secondo = new Evento("Pinocchio", LocalDate.of(2026, 12, 25), 200);

        // Aggiunta eventi nella lista *programma*
        programma.AggiungiEvento(primo);
        programma.AggiungiEvento(secondo);

        System.out.println(programma.titolo);
        System.out.println("Programma:");
        for (Evento e : programma.eventi) {
            System.out.println("- " + e);

        }

        // Indicazione degli eventi in una determinata data
        programma.EventiInData(LocalDate.of(2027, 12, 25));

        // Indicazione del numeri di eventi caricati
        System.out.println(programma.NumeroEventiPresenti());

        // Svuota lista con prova
        programma.SvuotaLista();

        System.out.println(programma.titolo);
        System.out.println("Programma:");
        for (Evento e : programma.eventi) {
            System.out.println("- " + e);

        }

    }
}
