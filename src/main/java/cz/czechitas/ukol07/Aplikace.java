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
        List<String> vsechnyKnihy = knihaSluzba.vratSeznamKnih();
        if (vsechnyKnihy.isEmpty()) {
            System.out.println("V databázy nejsou žásné knihy.");
        } else {
            System.out.println("Knihy v databázi:");
            vsechnyKnihy.forEach((kniha) -> System.out.printf("- %s", kniha).println());
        }

        List<String> knihyKarelCapek = knihaSluzba.vratKnihyOdAutora("Karel Čapek");
        if (vsechnyKnihy.isEmpty()) {
            System.out.println("Karel Čapek nic nenapsal.");
        } else {
            System.out.println("Knihy od Karla Čapka:");
            knihyKarelCapek.forEach((kniha) -> System.out.printf("- %s", kniha).println());
        }

        List<String> knihyZRoku1945 = knihaSluzba.vratKnihyZRoku(1945);
        if (vsechnyKnihy.isEmpty()) {
            System.out.println("V roce 1945 nevyšla kniha.");
        } else {
            System.out.println("Knihy z roku 1945:");
            knihyZRoku1945.forEach((kniha) -> System.out.printf( + " : " + knihaSluzba.getKnihy().getFirst().getNazev() + "- %s", kniha).println());
        }
    }
}
