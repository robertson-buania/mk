package com.example.demo.dao;

import net.buania.mkprodback.entities.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivraisonRepository  extends JpaRepository<Livraison,Long> {
}
