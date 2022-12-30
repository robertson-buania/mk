package com.example.demo.dto;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Engindto {
    private String nom;

    private String description;
    private Double derniereConsommation;
    private Date derniereDate;

    public Engindto() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getDerniereConsommation() {
        return derniereConsommation;
    }

    public void setDerniereConsommation(Double derniereConsommation) {
        this.derniereConsommation = derniereConsommation;
    }

    public Date getDerniereDate() {
        return derniereDate;
    }

    public void setDerniereDate(Date derniereDate) {
        this.derniereDate = derniereDate;
    }
}
