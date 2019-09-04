package com.BeerAssistente.Beer.Assistente.Gerenciador.responses;

import com.BeerAssistente.Beer.Assistente.Gerenciador.spotfy.BeerPlaylist;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;


public class CervejaResponse<T> {

    private final String tipoCerveja;
    @JsonProperty("lista de músicas")
    private final BeerPlaylist beerPlaylist;
    private List<String> errors;

    public CervejaResponse(String tipoCerveja, BeerPlaylist beerplaylist, BeerPlaylist beerPlaylist){
        this.tipoCerveja = tipoCerveja;
        this.beerPlaylist = beerPlaylist;
    }

    public String getTipoCerveja() {
        return tipoCerveja;
    }

    public BeerPlaylist setBeerPlaylist() {
       return beerPlaylist;
    }

    public List <String>getErrors(){
        if (this.errors==null){
            this.errors = new ArrayList<String>();
        }
        return errors;
    }

    public void setErrors (List<String> errors) {
        this.errors = errors;
    }

    public CervejaResponse(String tipoCerveja, BeerPlaylist beerPlaylist) {
        this.tipoCerveja = tipoCerveja;
        this.beerPlaylist = null;
    }
    @Override
    public String toString() {
        return "Cerveja[" +
                "Tipo de Cerveja='" + tipoCerveja + '\'' +
                ", beer Playlist=" + beerPlaylist +
                '}';
    }
}
