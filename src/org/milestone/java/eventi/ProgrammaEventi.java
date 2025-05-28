package org.milestone.java.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammaEventi {

    String titolo;
    List<Evento> eventi;

    public ProgrammaEventi(String titolo) {
        this.titolo = titolo;
        eventi = new ArrayList<>();
    }

    public void AggiungiEvento(Evento eventoDaAggiungere) {
        eventi.add(eventoDaAggiungere);
    }

    public void EventiInData(LocalDate dataInserita) {
        System.out.println("Eventi in questa data: ");
        for (int i = 0; i < eventi.size(); i++) {

            if (eventi.get(i).getData().isEqual(dataInserita)) {

                System.out.println("- " + eventi.get(i));
            }
        }
    }

    public String NumeroEventiPresenti() {
        return "Sono presenti " + eventi.size() + " eventi in questo programma";
    }

    public void SvuotaLista() {
        eventi.clear();
    }

    @Override
    public String toString() {
        return "ProgrammaEventi{" +
                "titolo='" + titolo + '\'' +
                ", eventi=" + eventi +
                '}';
    }

}