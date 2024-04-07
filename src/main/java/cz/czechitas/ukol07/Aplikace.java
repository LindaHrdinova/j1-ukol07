package cz.czechitas.ukol07;

import java.io.IOException;
import java.util.List;

/**
 * Spouštěcí třída aplikace
 */
public class Aplikace {

    public static void main(String[] args) throws IOException {
        new Aplikace().run();
    }

    /**
     * Hlavní metoda obsahující výkonný kód.
     */
    public void run() throws IOException {
        KnihaSluzba knihaSluzba = new KnihaSluzba();

        List<Kniha> vsechnyKnihy = knihaSluzba.vratSeznamKnih();
        if (vsechnyKnihy.isEmpty()) {
            System.out.println("V databázy nejsou žásné knihy.");
        } else {
            System.out.println("Knihy v databázi:");
            vsechnyKnihy.forEach(System.out::println);
        }

        List<Kniha> knihyKarelCapek = knihaSluzba.vratKnihyOdAutora("Karel Čapek");
        if (vsechnyKnihy.isEmpty()) {
            System.out.println("Karel Čapek nic nenapsal.");
        } else {
            System.out.println("Knihy od Karla Čapka:");
            knihyKarelCapek.forEach(System.out::println);
        }

        List<Kniha> knihyZRoku1945 = knihaSluzba.vratKnihyZRoku(1845);
        if (vsechnyKnihy.isEmpty()) {
            System.out.println("V roce 1945 nevyšla kniha.");
        } else {
            System.out.println("Knihy z roku 1845:");
            knihyZRoku1945.forEach(kniha -> System.out.println(kniha));  // stejný, ale srozumitelnější zápis pro "profi" zápis: knihyZRoku1945.forEach(System.out::println)
        }
    }
}
