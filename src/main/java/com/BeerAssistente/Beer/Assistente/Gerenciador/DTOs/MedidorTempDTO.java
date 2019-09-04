package com.BeerAssistente.Beer.Assistente.Gerenciador.DTOs;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class MedidorTempDTO implements Serializable {
    private int tempMin;
    private int tempMax;
    private Long id;

    public MedidorTempDTO(){
    }
    @NotNull(message = "Info obrigatoria")
    @Length(min = 1, max=2, message = "temperatura deve estar entre 1 e 2 caracteres")
    public int getTempMin() {
        return tempMin;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }
    @NotNull(message = "Info obrigatoria")
    @Length(min = 1, max=2, message = "temperatura deve estar entre 1 e 2 caracteres")
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

    @Override
    public String toString(){
        return "Temperatura ideal["+ "temperatura mínima="+ tempMin+ "e temperatura máxima= "+tempMax+"]";
    }
}
