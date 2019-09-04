package com.BeerAssistente.Beer.Assistente.Gerenciador.DTOs;

import com.BeerAssistente.Beer.Assistente.Gerenciador.entities.MedidorTemp;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class CervejaDto implements Serializable {

    private Long id;

    private String tipoCerveja;

    private MedidorTemp freezer;

    public CervejaDto(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull (message = "Info obrigatoria")
    @Length(min = 3, max=40, message = "nome deve estar entre 3 e 4 caracteres")
    public String getTipoCerveja() {
        return tipoCerveja;
    }

    public void setTipoCerveja(String tipoCerveja) {
        this.tipoCerveja = tipoCerveja;
    }

    public MedidorTemp getFreezer() {
        return freezer;
    }

    public void setFreezer(MedidorTemp freezer) {
        this.freezer = freezer;
    }

    @Override
    public String toString(){
        return "Cerveja[tipo="+ tipoCerveja+",temperatura ideal" +freezer+ "]";
    }

}
