package com.example.demo.services;

import com.example.demo.dao.ProduitRepository;
import com.example.demo.entities.Produit;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProduitServiceImpl implements MkprodService<Produit>{



    private ProduitRepository produitRepository;

    public ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public List<Produit> all() {
        return produitRepository.findAll(Sort.by(Sort.Order.desc("id")));
    }

    @Override
    public Produit findOne(Long id) {
        return produitRepository.findById(id).get();
    }
    public Produit findOneByName(String nom) {
        return produitRepository.findDistinctByNomContains(nom);
    }
    @Override
    public Produit saveOne(Produit produit) {
        return produitRepository.save(produit);
    }
    @Override
    public boolean delete(Long id) {
        Produit produit=findOne(id);

        if(produit!=null){
            produitRepository.delete(findOne(id));
            return true;
        }else{
            return false;
        }

    }

}