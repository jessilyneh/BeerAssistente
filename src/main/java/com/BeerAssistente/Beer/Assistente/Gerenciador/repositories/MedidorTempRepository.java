package com.BeerAssistente.Beer.Assistente.Gerenciador.repositories;

import com.BeerAssistente.Beer.Assistente.Gerenciador.entities.MedidorTemp;
import org.springframework.data.repository.CrudRepository;

public interface MedidorTempRepository extends CrudRepository<MedidorTemp, Integer> {
MedidorTemp findByMinAndMax(int tempMin, int tempMax);

    MedidorTemp save();
}


