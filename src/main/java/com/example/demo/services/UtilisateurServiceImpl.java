package com.example.demo.services;

import net.buania.mkprodback.dao.UtilisateurRepository;
import net.buania.mkprodback.entities.Utilisateur;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurServiceImpl implements MkprodService<Utilisateur>{



    private UtilisateurRepository utilisateurRepository;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public List<Utilisateur> all() {
        return utilisateurRepository.findAll(Sort.by(Sort.Order.desc("id")));
    }

    @Override
    public Utilisateur findOne(Long id) {
        return utilisateurRepository.findById(id).get();
    }

    @Override
    public Utilisateur saveOne(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public boolean delete(Long id) {
        Utilisateur utilisateur=findOne(id);

        if(utilisateur!=null){
            utilisateurRepository.delete(findOne(id));
            return true;
        }else{
            return false;
        }

    }
}