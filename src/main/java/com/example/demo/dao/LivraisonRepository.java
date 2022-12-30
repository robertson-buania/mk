package com.example.demo.dao;

import com.example.demo.entities.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivraisonRepository  extends JpaRepository<Livraison,Long> {
}
