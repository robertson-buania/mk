package com.example.demo.dao;

import com.example.demo.entities.Engin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface EnginRepository extends JpaRepository<Engin,Long> {
    Engin findDistinctByNomContains(@Param("nom")String nom);
}
