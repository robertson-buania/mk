package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Livraison implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30)
    private String nomclient;
    @Column(length = 15)
    private String telclient;
    @Column(length = 10)
    private String plaque;
    private Double poidstare;
    private Double poidsbrute;
    private Double poidsnet;

    @Column(length = 30)
    private String destination;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Produit produit;
    @Column(length = 15)
    private String bonlivraison;
    @Column(length = 15)
    private String lieuvente;

    @Temporal(TemporalType.DATE)
    private Date datecreation;

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public Livraison() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumclient() {
        return nomclient;
    }

    public void setNumclient(String numclient) {
        this.nomclient = numclient;
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

    public void setPoidsnet(Double poidsnet) {
        this.poidsnet= poidsnet;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
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
