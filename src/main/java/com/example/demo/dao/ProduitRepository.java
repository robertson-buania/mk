package com.example.demo.dao;

import net.buania.mkprodback.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ProduitRepository extends JpaRepository<Produit,Long> {

    Produit findDistinctByNomContains(@Param("nom")String nom);
}
