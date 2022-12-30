package com.example.demo.dto;

import java.io.Serializable;
import java.util.Date;

public class Livraisondto implements Serializable {

    private Long id;

    private  String nomclient;
    private String telclient;

    private String plaque;
    private Double poidstare;
    private Double poidsbrute;
    private Double poidsnet;


    private String destination;

    private String produit;

    private String bonlivraison;

    private String lieuvente;


    private Date datecreation;

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public Livraisondto() {
    }

    public String getNomclient() {
        return nomclient;
    }

    public void setNomclient(String nomclient) {
        this.nomclient = nomclient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTelclient() {
        return telclient;
    }

    public void setTelclient(String telclient) {
        this.telclient = telclient;
    }

    public String getPlaque() {
        return plaque;
    }

    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }

    public Double getPoidstare() {
        return poidstare;
    }

    public void setPoidstare(Double poidstare) {
        this.poidstare = poidstare;
    }

    public Double getPoidsbrute() {
        return poidsbrute;
    }

    public void setPoidsbrute(Double poidsbrute) {
        this.poidsbrute = poidsbrute;
    }

    public Double getPoidsnet() {
        return poidsnet;
    }

    public void setPoidsnet(Double poidsnette) {
        this.poidsnet = poidsnette;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public String getBonlivraison() {
        return bonlivraison;
    }

    public void setBonlivraison(String bonlivraison) {
        this.bonlivraison = bonlivraison;
    }

    public String getLieuvente() {
        return lieuvente;
    }

    public void setLieuvente(String lieuvente) {
        this.lieuvente = lieuvente;
    }
}
