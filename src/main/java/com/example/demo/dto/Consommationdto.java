package com.example.demo.dto;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class Consommationdto implements Serializable {

    private Long id;
    private String heurechargement;
    private Double nombrelitre;
    private Date periodedebut;
    private Date periodefin;
    private String engin;
    private Date datecreation;

    public Consommationdto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeurechargement() {
        return heurechargement;
    }

    public void setHeurechargement(String heurechargement) {
        this.heurechargement = heurechargement;
    }

    public Double getNombrelitre() {
        return nombrelitre;
    }

    public void setNombrelitre(Double nombrelitre) {
        this.nombrelitre = nombrelitre;
    }

    public Date getPeriodedebut() {
        return periodedebut;
    }

    public void setPeriodedebut(Date periodedebut) {
        this.periodedebut = periodedebut;
    }

    public Date getPeriodefin() {
        return periodefin;
    }

    public void setPeriodefin(Date periodefin) {
        this.periodefin = periodefin;
    }

    public String getEngin() {
        return engin;
    }

    public void setEngin(String engin) {
        this.engin = engin;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }
}

