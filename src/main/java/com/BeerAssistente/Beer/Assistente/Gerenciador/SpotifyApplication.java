package com.BeerAssistente.Beer.Assistente.Gerenciador;

import com.BeerAssistente.Beer.Assistente.Gerenciador.DTOs.CervejaDto;
import com.BeerAssistente.Beer.Assistente.Gerenciador.entities.Cerveja;
import com.BeerAssistente.Beer.Assistente.Gerenciador.services.CervejaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpotifyApplication implements CommandLineRunner {

    private final CervejaServices cervejaServices;

    @Autowired
    public SpotifyApplication (CervejaServices cervejaServices) {
        this.cervejaServices = cervejaServices;
    }

    @Override
    public void run(String... args) throws Exception {

    }

    private void cervejasIniciais() {
        cervejaServices.salvar(new CervejaDto("IPA", -7,10));
    }
}
