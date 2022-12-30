package com.example.demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Mazout implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long reserve;

    @Temporal(TemporalType.DATE)
    private Date datecreation;

    public Mazout() {
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

    public Long getReserve() {
        return reserve;
    }

    public void setReserve(Long reserve) {
        this.reserve = reserve;
    }
}
