package com.BeerAssistente.Beer.Assistente.Gerenciador.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MedidorTemp {

    @Id
    @GeneratedValue
    private int tempMin;
    private int tempMax;
    private Long id;

    public MedidorTemp(int tempMin, int tempMax){
        this.tempMin=tempMin;
        this.tempMax=tempMin;
    }

    public MedidorTemp() {

    }

    public int getTempMin() {
        return tempMin;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }

    public int getTempMax() {
        return tempMax;
    }

    public void setTempMax(int tempMax) {
        this.tempMax = tempMax;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTempIdeal() {
        return(tempMin+tempMax) / 2;
    }

    @Override
    public String toString(){
        return "Temperatura ideal["+ "temperatura mínima="+ tempMin+ "e temperatura máxima= "+tempMax+"]";
    }
}
