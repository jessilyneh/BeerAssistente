package com.BeerAssistente.Beer.Assistente.Gerenciador.services;

import com.BeerAssistente.Beer.Assistente.Gerenciador.DTOs.CervejaDto;
import com.BeerAssistente.Beer.Assistente.Gerenciador.controller.GerenciadorCervejaController;
import com.BeerAssistente.Beer.Assistente.Gerenciador.entities.Cerveja;
import com.BeerAssistente.Beer.Assistente.Gerenciador.repositories.CervejaRepository;
import com.BeerAssistente.Beer.Assistente.Gerenciador.repositories.MedidorTempRepository;
import com.BeerAssistente.Beer.Assistente.Gerenciador.responses.CervejaResponse;
import com.BeerAssistente.Beer.Assistente.Gerenciador.services.exceptions.CervejaServiceException;
import com.BeerAssistente.Beer.Assistente.Gerenciador.spotfy.BeerPlaylist;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.logging.Logger;

@Service
public class CervejaServices {

    private static final Logger LOGGER = Logger.getLogger(GerenciadorCervejaController.class.getName());
    private CervejaRepository cervejaRepository;
    private MedidorTempRepository medidorTempRespository;
    private CervejaServices cervejaServices;
    private BeerPlaylist beerPlaylist;

    @GetMapping("/cerveja/{medidortemp}")
    public ResponseEntity<CervejaResponse> getMatch (@PathVariable Integer medidortemp){
        LOGGER.info("Fazer Match de cerveja e playlist");
        ResponseEntity<CervejaResponse> response;
        Cerveja cerveja = cervejaServices.getCervejaPerfeita (medidortemp);
        BeerPlaylist beerPlaylist = SpotifyServices.BeerPlaylist(cerveja.getTipoCerveja());
        CervejaResponse cervejaResponse = new CervejaResponse(cerveja.getTipoCerveja(),beerPlaylist);
        LOGGER.info(cervejaResponse.toString());
        if (beerPlaylist != null) {
            response = ResponseEntity.status(HttpStatus.OK).body(cervejaResponse);
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(cervejaResponse);
        }
        return response;
    }

    public ResponseEntity<CervejaResponse> error(Integer value) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CervejaResponse("error",null ));
    }


    private Cerveja getCervejaPerfeita(Integer medidortemp) {
        return null;
    }

    public List<Cerveja> listar() {
        return cervejaRepository.findAll();
    }

    public Cerveja salvar(CervejaDto cervejaDto){

        Cerveja cerveja = new Cerveja();

        cerveja.setTipoCerveja(cervejaDto.getTipoCerveja());
        cerveja.setFreezer(cervejaDto.getFreezer());
        return cervejaRepository.save(cerveja);
    }

    public Cerveja buscar(Long id) throws CervejaServiceException {
        Cerveja cerveja = CervejaRepository.findOne(id);

        if (cerveja == null){
            throw new CervejaServiceException("Nao existe o tipo cadastrado");
        }
        return cerveja;
    }

    public List<Cerveja> findByTipoCerveja(String tipoCerveja) throws CervejaServiceException {
        List<Cerveja> cervejas = cervejaRepository.findAllByTipoCerveja(tipoCerveja);
        if (cervejas.isEmpty()){
            throw new CervejaServiceException("Nao existem cervejas cadastradas");
        }
        return cervejas;
    }

    public List<Cerveja>deletar(Cerveja cerveja){
        cervejaRepository.delete(cerveja);
        return cervejaRepository.findAll();
    }

    public Cerveja buscarSemTratativa(Long id){
        Cerveja cerveja = CervejaRepository.findOne(id);

        return cerveja;
    }

    public Cerveja alterar (CervejaDto cervejaDto, Long id) {

        Cerveja cervejaExistente = CervejaRepository.findOne(id);

           cervejaExistente.setTipoCerveja(cervejaDto.getTipoCerveja());
           cervejaExistente.setFreezer(cervejaDto.getFreezer());
           return cervejaRepository.save(cervejaExistente);
        }
    }


