package org.milestone.java.eventi;

import java.text.NumberFormat;
import java.time.DateTimeException;
import java.time.LocalDate;

public class Evento {
    private String titolo;
    private LocalDate data;
    private int nPostiTotali;
    private int nPostiPrenotati;

    public Evento(String titolo, LocalDate data, int nPostiTotali) throws Exception {
        this.titolo = titolo;
        this.data = data;
        // setData(this.data);
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

    public boolean esistonoPosti() {
        if (this.nPostiTotali <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public void setNPostiTotali(int nPostiTotali) throws Exception {
        if (esistonoPosti() == true) {
            this.nPostiTotali = nPostiTotali;
        } else if (esistonoPosti() == false) {
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

    public void prenota(int postiDaAggiungere) throws Exception, DateTimeException{
        LocalDate dataCorrente = LocalDate.now();
         nPostiPrenotati = nPostiPrenotati + postiDaAggiungere;
       
        if (nPostiPrenotati >= nPostiTotali) {
            throw new Exception();
           
        } 
        if (dataCorrente.isAfter(this.data)){
   
        }
    }

    public void disdici(int postiDaTogliere) throws Exception {
        LocalDate dataCorrente = LocalDate.now();

        if (nPostiPrenotati == 0 || dataCorrente.isAfter(this.data) || nPostiPrenotati < postiDaTogliere) {
            throw new Exception(
                    "Non ci sono prenotazioni o l'evento è passato o i posti da togliere sono maggiori dei prenotati");
        } else {
            nPostiPrenotati = nPostiPrenotati - postiDaTogliere;
        }
    }

    public String toString() {
        return "Questi sono i dati:" + this.titolo + " " + this.data + " Posti totali " + getNPostiTotali()
                + " Posti prenotati " + getNPostiPrenotati();
    }

}
