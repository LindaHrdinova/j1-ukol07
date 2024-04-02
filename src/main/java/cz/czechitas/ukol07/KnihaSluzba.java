package cz.czechitas.ukol07;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class KnihaSluzba {
    private List<Kniha> knihy; // knihy = 14

    public List<Kniha> getKnihy() {
        return knihy;
    }

    public void setKnihy(List<Kniha> knihy) {
        this.knihy = knihy;
    }

    public static class SeznamKnih {
        private List<Kniha> knihy;

        public List<Kniha> getKnihy() {
            return knihy;
        }

        public void setKnihy(List<Kniha> knihy) {
            this.knihy = knihy;
        }
    }
    private SeznamKnih seznamKnih; // null

    private final ObjectMapper objectMapper = JsonMapper.builder()
            .addModule(new JavaTimeModule())
            .build();

    public KnihaSluzba() throws IOException {
        this.seznamKnih = seznamKnih;
        // proč cesta není "src/main/resources/cz/czechitas/ukol07/knihy.json" ?
        InputStream knihyStream = KnihaSluzba.class.getResourceAsStream("knihy.json");
        knihy = objectMapper.readValue(knihyStream, new TypeReference<List<Kniha>>() {
        });
        //try(){};
    }

    public List<String> vratSeznamKnih() {
        return seznamKnih.getKnihy()
                .stream().map(Kniha::getNazev)
                .toList();
    }

    public List<String> vratKnihyOdAutora(String autor) {
        return seznamKnih.getKnihy().stream()
                .filter(kniha -> kniha.getAutor().equals(autor))
                .map(Kniha::getNazev)
                .toList();
    }

    public List<String> vratKnihyZRoku(Number rokVydani) {
        return seznamKnih.getKnihy().stream()
                .filter(kniha -> kniha.getRokVydani().equals(rokVydani))
                .map(Kniha::getNazev)
                .toList();
    }

}
