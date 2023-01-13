package com.example.demo.sec.entities;

import javax.persistence.*;

@Entity
public class AppRole {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 7)
    private String roleName;

    public AppRole(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public AppRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
