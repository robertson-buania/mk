package com.example.demo.dao;

import net.buania.mkprodback.entities.Consommationmazout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsommationmazoutRepository extends JpaRepository<Consommationmazout,Long> {

    public Consommationmazout findDistinctFirstByEngin_Nom(String nom);
}
