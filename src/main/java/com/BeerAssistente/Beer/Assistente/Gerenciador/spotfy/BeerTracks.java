package com.BeerAssistente.Beer.Assistente.Gerenciador.spotfy;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BeerTracks {
    private String nome;
    private String artista;
    @JsonProperty("link")
    private String href;

    public BeerTracks(String nome, String artista, String href){
        this.nome=nome;
        this.artista=artista;
        this.href=href;
    }

    public BeerTracks(String name) {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "DuffTrack{" +
                "nome='" + nome + '\'' +
                ", artista='" + artista + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
