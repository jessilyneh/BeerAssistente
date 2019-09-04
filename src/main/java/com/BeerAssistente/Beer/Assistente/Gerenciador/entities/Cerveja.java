package com.BeerAssistente.Beer.Assistente.Gerenciador.entities;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Component
@Table (name = "cerveja")
public class Cerveja implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "tipo_cerveja", nullable = false)
    private String tipoCerveja;


    @OneToOne
    private MedidorTemp freezer;

    public Cerveja (String tipoCerveja, MedidorTemp freezer){
        this.tipoCerveja = tipoCerveja;
        this.freezer=freezer;
    }

    //@JsonSerialize(using = NumberSerializers.FloatSerializer.class)
    //@Column(name = "temp_maxima",nullable = true)
    //private float tempMax;

    //@Column(name = "temp_minima",nullable = true)
    //private float tempMin;

    public Cerveja() {

    }
    //Construtor
    public Cerveja(String tipoCerveja, int tempMax, int tempMin) {
        this.tipoCerveja = tipoCerveja;
        this.freezer = new MedidorTemp(tempMin,tempMax);
    }

    //getters e setters
    //@JsonFormat(shape = JsonFormat.Shape.NUMBER_INT, pattern = "")
    //public Integer getTempMax() {

    //    return tempMax;
    //}

   // public void setTempMax(float tempMax) {
   //     this.tempMax = tempMax;
   // }
   // @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT, pattern = "")
   // public  getTempMin() {
   //     return tempMin;
   // }

   // public void setTempMin(float tempMin) {
   //     this.tempMin = tempMin;
   // }


    public MedidorTemp getFreezer() {
        return freezer;
    }

    public void setFreezer (MedidorTemp freezer){
        this.freezer = freezer;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getTipoCerveja() {
        return tipoCerveja;
    }

    public void setTipoCerveja(String tipoCerveja) {
        this.tipoCerveja = tipoCerveja;
    }
    //formatacao dos campos JSON na hora de retornar o resultado

    @Override
    public String toString() {
        return "Cerveja[tipo="+ tipoCerveja+",temperatura ideal" +freezer+ "]";

    }
}