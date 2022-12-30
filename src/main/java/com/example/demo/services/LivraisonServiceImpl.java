package com.example.demo.services;

import com.example.demo.dao.LivraisonRepository;
import com.example.demo.entities.Livraison;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LivraisonServiceImpl implements MkprodService<Livraison>{

    private LivraisonRepository livraisonRepository;

    public LivraisonServiceImpl(LivraisonRepository livraisonRepository) {
        this.livraisonRepository = livraisonRepository;
    }

    @Override
    public List<Livraison> all() {
        return livraisonRepository.findAll(Sort.by(Sort.Order.desc("id")));
    }

    @Override
    public Livraison findOne(Long id) {
        return livraisonRepository.findById(id).get();
    }

    @Override
    public Livraison saveOne(Livraison livraison) {
       return livraisonRepository.save(livraison);
    }

    @Override
    public boolean delete(Long id) {
       return false;

    }


}