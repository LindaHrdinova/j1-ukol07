package cz.czechitas.ukol07.knihy;

import cz.czechitas.ukol07.KnihaSluzba;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.MonthDay;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnihySluzbaTest {
    KnihaSluzba knihy = new KnihaSluzba();

    public KnihySluzbaTest() throws IOException {
    }

    @Test
    void vyhledatPocetKnihOdAutora() {
        assertEquals(3, knihy.vratKnihyOdAutora("Josef Čapek").size());
    }

    @Test
    void vyhledatKnihyKRoku() {
        assertEquals(List.of("V zámku a podzámčí", "Božena Němcová"), knihy.vratKnihyZRoku(1856));
    }

    @Test
    void pocetVsechKnih() {
        assertEquals(14, knihy.vratSeznamKnih().size());
    }

    @Test
    void vyhledatKnihyOdAutora() {
        assertTrue(knihy.vratKnihyOdAutora("Karel Jaromír Erben").isEmpty());
    }
}