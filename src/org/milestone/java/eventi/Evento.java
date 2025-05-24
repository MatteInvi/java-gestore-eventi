package org.milestone.java.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
    private String titolo;
    private LocalDate data;
    private int nPostiTotali;
    private int nPostiPrenotati;

    public Evento(String titolo, LocalDate data, int nPostiTotali) throws Exception {
        this.titolo = titolo;
        this.data = data;
        setData(this.data);
        this.nPostiTotali = nPostiTotali;
        setNPostiTotali(this.nPostiTotali);
        this.nPostiPrenotati = 0;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) throws Exception {
        LocalDate dataCorrente = LocalDate.now();

        if (dataCorrente.isBefore(data)) {
            this.data = data;
        } else {
            throw new Exception("Data già passata");
        }
    }

    public void setNPostiTotali(int nPostiTotali) throws Exception {
        if (this.nPostiTotali > 0) {
            this.nPostiTotali = nPostiTotali;
        } else {
            throw new Exception("I posti non possono essere inferiori a 1");
        }
    }

    public int getNPostiTotali() {
        return nPostiTotali;
    }

    public int getNPostiPrenotati() {
        return this.nPostiPrenotati;
    }

    public void setNPostiPrenotati(int nPostiPrenotati) {
        this.nPostiPrenotati = nPostiPrenotati;
    }

    public void prenota(int postiDaAggiungere) throws Exception {
        nPostiPrenotati = nPostiPrenotati + postiDaAggiungere;

        if (nPostiPrenotati > nPostiTotali) {
            throw new Exception("Non ci sono posti disponibili");
        }

    }

    public void disdici(int postiDaTogliere) throws Exception {

        if (postiDaTogliere == 0) {
            throw new Exception("Non puoi inserire 0 posti");
        } else if (nPostiPrenotati < postiDaTogliere) {
            throw new Exception("Non puoi eliminare più posti di quelli che hai prenotato");
        } else {
            nPostiPrenotati = nPostiPrenotati - postiDaTogliere;
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormattata = this.data.format(formatter);
        return "Data evento: " + dataFormattata + " Titolo: " + this.titolo;
        // return "Questi sono i dati:" + this.titolo + " " + this.data + " Posti totali
        // " + getNPostiTotali()
        // + " Posti prenotati " + getNPostiPrenotati();
    }

}
