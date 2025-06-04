package org.milestone.java.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.milestone.java.eventi.exceptions.ExceptionDataPassata;
import org.milestone.java.eventi.exceptions.ExceptionNessunaPrenotazione;
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

// Getter e Setter (con eventuali controlli)
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

    public int getNPostiTotali() {
        return nPostiTotali;
    }

    private void setNPostiTotali(int nPostiTotali) throws ExceptionNumeroNonValido {
        if (this.nPostiTotali > 0) {
            this.nPostiTotali = nPostiTotali;
        } else {
            throw new ExceptionNumeroNonValido("I posti non possono essere inferiori a 1");
        }
    }

    public int getNPostiPrenotati() {
        return this.nPostiPrenotati;
    }

    private void setNPostiPrenotati(int nPostiPrenotati) {
        this.nPostiPrenotati = nPostiPrenotati;
    }

// Prenotazione posti
    public void prenota(int postiDaAggiungere) throws ExceptionNumeroNonValido, ExceptionPostiEsauriti {
        if (postiDaAggiungere <= 0) {
            throw new ExceptionNumeroNonValido("Non puoi inserire un numero inferiore di 1");

        }
        nPostiPrenotati = nPostiPrenotati + postiDaAggiungere;

        if (nPostiPrenotati > nPostiTotali) {
            throw new ExceptionPostiEsauriti("Non ci sono posti disponibili");
        }

    }

// Disdetta posti
    public void disdici(int postiDaTogliere) throws ExceptionNumeroNonValido, ExceptionNessunaPrenotazione {
        if (postiDaTogliere <= 0) {
            throw new ExceptionNumeroNonValido("Non puoi inserire un numero inferiore di 1");
        }
        
        if (postiDaTogliere > nPostiPrenotati) {
            throw new ExceptionNessunaPrenotazione("Non puoi disdire più posti di quelli prenotati");
        } else {
            nPostiPrenotati = nPostiPrenotati - postiDaTogliere;
        }
    }

// Metodo toString
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormattata = this.data.format(formatter);
        return "Data evento: " + dataFormattata + " Titolo: " + this.titolo;

    }

}
