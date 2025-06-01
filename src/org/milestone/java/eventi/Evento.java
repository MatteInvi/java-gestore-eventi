package org.milestone.java.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.milestone.java.eventi.exceptions.ExceptionDataPassata;
import org.milestone.java.eventi.exceptions.ExceptionNumeroNonValido;
import org.milestone.java.eventi.exceptions.ExceptionPostiEsauriti;

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

    public void setData(LocalDate data) throws ExceptionDataPassata {
        LocalDate dataCorrente = LocalDate.now();

        if (dataCorrente.isBefore(data)) {
            this.data = data;
        } else {
            throw new ExceptionDataPassata("Non puoi creare un evento con una data già passata");
        }
    }

    private void setNPostiTotali(int nPostiTotali) throws ExceptionNumeroNonValido {
        if (this.nPostiTotali > 0) {
            this.nPostiTotali = nPostiTotali;
        } else {
            throw new ExceptionNumeroNonValido("I posti non possono essere inferiori a 1");
        }
    }

    public int getNPostiTotali() {
        return nPostiTotali;
    }

    public int getNPostiPrenotati() {
        return this.nPostiPrenotati;
    }

    private void setNPostiPrenotati(int nPostiPrenotati) {
        this.nPostiPrenotati = nPostiPrenotati;
    }

    public void prenota(int postiDaAggiungere) throws ExceptionNumeroNonValido, ExceptionPostiEsauriti {
        nPostiPrenotati = nPostiPrenotati + postiDaAggiungere;

        if (nPostiPrenotati > nPostiTotali) {
            throw new ExceptionPostiEsauriti("Non ci sono posti disponibili");
        } else if (postiDaAggiungere <= 0) {
            throw new ExceptionNumeroNonValido("Non puoi inserire un numero inferiore di 1");
        }

    }

    public void disdici(int postiDaTogliere) throws ExceptionNumeroNonValido {

        if (postiDaTogliere <= 0) {
            throw new ExceptionNumeroNonValido("Non puoi inserire un numero inferiore di 1");
        } else if (nPostiPrenotati < postiDaTogliere) {
            throw new ExceptionNumeroNonValido("Non puoi eliminare più posti di quelli che hai prenotato");
        } else {
            nPostiPrenotati = nPostiPrenotati - postiDaTogliere;
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormattata = this.data.format(formatter);
        return "Data evento: " + dataFormattata + " Titolo: " + this.titolo;

    }

}
