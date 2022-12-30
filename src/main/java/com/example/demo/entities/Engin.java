package com.example.demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Engin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30,unique = true)
    private String nom;

    private String description;
    @OneToMany(mappedBy = "engin")
    private Collection <Consommationmazout> consommationmazouts;

    public Engin() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Collection<Consommationmazout> getConsommationmazouts() {
        return consommationmazouts;
    }

    public void setConsommationmazouts(Collection<Consommationmazout> consommationmazouts) {
        this.consommationmazouts = consommationmazouts;
    }
}
