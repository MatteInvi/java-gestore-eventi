package org.milestone.java.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProgrammaEventi {

    String titolo;
    List<Evento> eventi;

    public ProgrammaEventi(String titolo) {
        this.titolo = titolo;
        eventi = new ArrayList<>();
    }

// Aggiungi evento
    public void aggiungiEvento(Evento eventoDaAggiungere) {
        eventi.add(eventoDaAggiungere);
    }

// Ricerca per data
    public void eventiInData(LocalDate dataInserita) {
        List<Evento> listInData = new ArrayList<>();
        System.out.println("Eventi in questa data: ");
        for (int i = 0; i < eventi.size(); i++) {
            if (eventi.get(i).getData().isEqual(dataInserita)) {
                listInData.add(eventi.get(i));
            }
        }
        if (listInData.size() > 0) {
            for (int i = 0; i < listInData.size(); i++) {
                System.out.println(listInData.get(i));
            }
        } else {
            System.out.println("Non ci sono eventi in questa data");
        }

    }

// Totale eventi in programma
    public String numeroEventiPresenti() {
        if (eventi.size() > 0) {
            return "Sono presenti " + eventi.size() + " eventi in questo programma";
        } else {
            return "Non ci sono eventi in questo programma";
        }
    }

// Elimina eventi in programma
    public void svuotaLista() {
        eventi.clear();
    }

// Sistemazione in ordine per data
    public void mettiInOrdine() {
        // lambda...
        // eventi.sort((evento1, evento2) ->
        // (evento1.getData()).compareTo(evento2.getData()));

        Collections.sort(eventi, new Comparator<Evento>() {

            @Override
            public int compare(Evento e1, Evento e2) {
                return (e1.getData()).compareTo(e2.getData());
            }

        });

    }

}
