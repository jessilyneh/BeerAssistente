package com.BeerAssistente.Beer.Assistente.Gerenciador.services;

import com.BeerAssistente.Beer.Assistente.Gerenciador.entities.MedidorTemp;
import com.BeerAssistente.Beer.Assistente.Gerenciador.repositories.MedidorTempRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class MedidorTempServices {

    private MedidorTempRepository medidorTempRepository;

    @Autowired
    public MedidorTempServices(MedidorTempRepository MedidorTempRepository){
        this.medidorTempRepository = MedidorTempRepository;
    }


    MedidorTemp cerveja = new MedidorTemp(0,0);

    public MedidorTemp getMedidorTempRepository() {
        return medidorTempRepository.save();
    }
     //public MedidorTemp criarMedidorTemp(MedidorTemp newMedidorTemp){
      //  MedidorTemp medidorTemp= null;
      //  medidorTemp = MedidorTempRepository.save(newMedidorTemp);

      //  return medidorTemp;
    // }

    // public Iterable<MedidorTemp> lookup() {
      //  return MedidorTempRepository.findAll();
    // }
}
