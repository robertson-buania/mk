package com.example.demo.services;

import net.buania.mkprodback.dao.ProduitRepository;
import net.buania.mkprodback.entities.Produit;
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