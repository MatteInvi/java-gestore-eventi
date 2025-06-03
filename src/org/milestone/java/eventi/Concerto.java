package org.milestone.java.eventi;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;

public class Concerto extends Evento {

    private LocalTime ora;
    private Float prezzo;

    public Concerto(LocalTime ora, Float prezzo, String titolo, LocalDate data, int nPostiTotali) throws Exception {

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

    public Float getPrezzo() {
        return this.prezzo;
    }

    public void setPrezzo(Float prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        NumberFormat formattatore = NumberFormat.getCurrencyInstance(Locale.ITALY);
        return "Ora evento: " + this.ora + " " + super.toString() + " Prezzo: " + formattatore.format(this.prezzo);
    }

}
