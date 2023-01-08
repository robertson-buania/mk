package com.example.demo.dao;

import com.example.demo.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

    public Utilisateur findDistinctByNomContains( @Param("nom") String nom);

    public Utilisateur findDistinctByNomContainsAndPasswordLike( @Param("nom") String nom,@Param("password") String password);
}
