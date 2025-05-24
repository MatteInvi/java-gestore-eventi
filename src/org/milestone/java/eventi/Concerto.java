package org.milestone.java.eventi;

import java.time.LocalDate;
import java.time.LocalTime;

public class Concerto extends Evento {

    private LocalTime ora;
    private float prezzo;

    public Concerto(LocalTime ora, float prezzo, String titolo, LocalDate data, int nPostiTotali) throws Exception {

        this.ora = ora;
        this.prezzo = prezzo;
        super(titolo, data, nPostiTotali);

    }

    public LocalTime getOra() {
        return this.ora;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public float getPrezzo() {
        return this.prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Ora evento: " + this.ora + " " + super.toString() + " Prezzo: " + this.prezzo;
    }

}
