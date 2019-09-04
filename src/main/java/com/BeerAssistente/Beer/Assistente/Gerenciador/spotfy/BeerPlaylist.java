package com.BeerAssistente.Beer.Assistente.Gerenciador.spotfy;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BeerPlaylist {
    private Long playlistId;
    private String nome;
    @JsonProperty("tracks")
    private List<BeerTracks> beerTracks;

    public String getNome() {
        return nome;
    }

    public void setNome (String nome) {
        this.nome=nome;
    }

    public List<BeerTracks>getBeerTracks(){
        return beerTracks;
    }

    public void setBeerTracks(List<BeerTracks> beerTracks) {
        this.beerTracks = beerTracks;
    }

    public Long getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(Long playlistId) {
        this.playlistId = playlistId;
    }

    @Override
    public String toString(){
        return "BeerPlaylist["+ "nome="+ nome + '\''+",beerTracks="+ beerTracks+"]";
    }
}
