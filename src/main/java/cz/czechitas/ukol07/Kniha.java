package cz.czechitas.ukol07;

public class Kniha {
    private String autor;
    private String nazev;
    private Number rokVydani;

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

    public Number getRokVydani() {
        return rokVydani;
    }

    public void setRokVydani(Number rokVydani) {
        this.rokVydani = rokVydani;
    }
}
