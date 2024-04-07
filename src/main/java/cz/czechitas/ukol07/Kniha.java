package cz.czechitas.ukol07;

import java.util.Objects;

public class Kniha {
    private String autor;
    private String nazev;
    private int rokVydani;

    public Kniha(String autor, String nazev, int rokVydani) {
        this.autor = autor;
        this.nazev = nazev;
        this.rokVydani = rokVydani;
    }

    public Kniha() {
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor() {
        this.autor = autor;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public int getRokVydani() {
        return rokVydani;
    }

    public void setRokVydani(int rokVydani) {
        this.rokVydani = rokVydani;
    }

    @Override
    public String toString() {
        return autor + " : " + nazev;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kniha kniha = (Kniha) o;
        return rokVydani == kniha.rokVydani && Objects.equals(autor, kniha.autor) && Objects.equals(nazev, kniha.nazev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autor, nazev, rokVydani);
    }
}
