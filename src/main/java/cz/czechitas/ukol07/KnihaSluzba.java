package cz.czechitas.ukol07;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class KnihaSluzba {
    private List<Kniha> knihy;

    public List<Kniha> getKnihy() {
        return knihy;
    }

    public void setKnihy(List<Kniha> knihy) {
        this.knihy = knihy;
    }

    private final ObjectMapper objectMapper = JsonMapper.builder()
            .addModule(new JavaTimeModule())
            .build();

    // cesta "src/main/resources/cz/czechitas/ukol07/knihy.json"
    private InputStream knihyStream = KnihaSluzba.class.getResourceAsStream("knihy.json");

    public KnihaSluzba() throws IOException {
        knihy = objectMapper.readValue(knihyStream, new TypeReference<List<Kniha>>() {
        });
        //try(){};
    }

}
