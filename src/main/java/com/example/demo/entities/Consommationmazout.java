package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Consommationmazout implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 10)
    private String heurechargement;
    private Double nombrelitre;
    @Temporal(TemporalType.DATE)
    private Date periodedebut;
    @Temporal(TemporalType.DATE)
    private Date periodefin;
    @ManyToOne
    @JsonIgnore
    private Engin engin;

    @Temporal(TemporalType.DATE)
    private Date datecreation;

    public Consommationmazout() {
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
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

    public Engin getEngin() {
        return engin;
    }

    public void setEngin(Engin engin) {
        this.engin = engin;
    }
}
