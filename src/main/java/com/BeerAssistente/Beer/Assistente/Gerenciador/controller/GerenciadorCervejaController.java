package com.BeerAssistente.Beer.Assistente.Gerenciador.controller;

import com.BeerAssistente.Beer.Assistente.Gerenciador.DTOs.CervejaDto;
import com.BeerAssistente.Beer.Assistente.Gerenciador.entities.Cerveja;
import com.BeerAssistente.Beer.Assistente.Gerenciador.services.CervejaServices;
import com.BeerAssistente.Beer.Assistente.Gerenciador.services.exceptions.CervejaServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/cervejas")
public class GerenciadorCervejaController {

    @Autowired
    private CervejaServices cervejaServices;


    @PostMapping()
    public ResponseEntity<?> cadastrar(@Valid @RequestBody CervejaDto cervejaDto, BindingResult result, Response response) {

        Cerveja cervejaSalva = this.cervejaServices.salvar (cervejaDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cervejaDto.getId())
                .toUri();

        return ResponseEntity.created(location).body(cervejaSalva);
    }

    @GetMapping({"/beer"})
    public String home(){
        return "Bem vindo ao assistente de cervejas!";
    }


    @GetMapping ({"/listar"})
    public ResponseEntity<List<Cerveja>> listar(@RequestParam(value = "tipoCerveja", required = true) String tipoCerveja) {
        List<Cerveja> cervejas = null;

        if (tipoCerveja == null){
            cervejas = cervejaServices.listar();
        } else {
            try {
                cervejas = cervejaServices.findByTipoCerveja(tipoCerveja);
            } catch (CervejaServiceException e) {
                e.printStackTrace();
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(cervejas);
    }

    @GetMapping(path = "/buscar")
    public ResponseEntity<Object> buscar(@PathVariable("id")Long id){

        Cerveja cerveja = null;
        try {
            cerveja = cervejaServices.buscar(id);
        } catch (CervejaServiceException e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.OK).body(cerveja);
    }

    @DeleteMapping(path = "/delete/")
    public ResponseEntity<List<Cerveja>> delete(@PathVariable("id") Long id){
        Cerveja cerveja = cervejaServices.buscarSemTratativa(id);
        List<Cerveja> cervejas = cervejaServices.deletar(cerveja);

        return ResponseEntity.status(HttpStatus.OK).body(cervejas);
    }

    @PutMapping(path = "/alterar")
    public ResponseEntity<?> alterar( int id, @Valid CervejaDto cervejaDto) {
        Cerveja cerveja = this.cervejaServices.alterar(cervejaDto, (long) id);

        return ResponseEntity.status(HttpStatus.OK).body(cerveja);
            }

        }

