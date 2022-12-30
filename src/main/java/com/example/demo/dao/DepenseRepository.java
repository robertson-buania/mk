package com.example.demo.dao;

import com.example.demo.entities.Depense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepenseRepository extends JpaRepository<Depense,Long> {
}
