package cz.czechitas.ukol07.knihy;

import cz.czechitas.ukol07.Kniha;
import cz.czechitas.ukol07.KnihaSluzba;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        List<Kniha> ocekavanySeznamKnih = List.of(
                new Kniha("Božena Němcová", "V zámku a podzámčí", 1856),
                new Kniha("Božena Němcová", "Divá Bára", 1856)
        );
        assertEquals(ocekavanySeznamKnih, knihy.vratKnihyZRoku(1856));
    }

    @Test
    void vyhledatKnihyKRokuNazvySet() {
        Set<String> seznam = new HashSet<>(); //prázdná množila
        seznam.add("Divá Bára");
        seznam.add("Divá Bára"); // Set tímhle nahradí předchozí Divou Báru, proto mi test nespadne na duplicitách.
        seznam.add("Divá Bára");
        seznam.add("Divá Bára");
        seznam.add("V zámku a podzámčí");
        assertEquals(
                //Set.of("Divá Bára", "V zámku a podzámčí", "V zámku a podzámčí"),
                seznam,
                knihy.vratKnihyZRoku(1856).stream()
                        .map(Kniha::getNazev)
                        .collect(Collectors.toSet()));
    }

    @Test
    void vyhledatKnihyKRokuNazvyLsit() {
        assertEquals(
                List.of("V zámku a podzámčí", "Divá Bára"),
                knihy.vratKnihyZRoku(1856).stream()
                        .map(Kniha::getNazev)
                        .toList());
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