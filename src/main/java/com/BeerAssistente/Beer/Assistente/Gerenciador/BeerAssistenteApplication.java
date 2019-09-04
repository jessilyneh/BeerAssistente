package com.BeerAssistente.Beer.Assistente.Gerenciador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@Configuration
public class BeerAssistenteApplication {

	public static void main(String[] args) {

		SpringApplication.run(BeerAssistenteApplication.class, args);
	}

}
