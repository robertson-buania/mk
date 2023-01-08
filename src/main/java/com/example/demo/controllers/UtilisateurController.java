package com.example.demo.controllers;

import com.example.demo.dao.UtilisateurRepository;
import com.example.demo.entities.Utilisateur;
import com.example.demo.services.UtilisateurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("api/utilisateur/")
@CrossOrigin("*")
public class UtilisateurController {


    @Autowired
    private UtilisateurRepository utilisateurRepository;
    private UtilisateurServiceImpl utilisateurService;

    public UtilisateurController(UtilisateurServiceImpl utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("all")
    public List<Utilisateur> findAllUtilisateurs(){
        return utilisateurService.all();

    }

    @GetMapping("select")
    public Utilisateur findOneUtilisateur(@PathParam("id") int id){

        return utilisateurService.findOne((long) id);

    }
    @PostMapping("select")
    public String onSaveProduit(@RequestBody Utilisateur utilisateur){
      Utilisateur user=  utilisateurRepository.findDistinctByNomContainsAndPasswordLike(utilisateur.getNom(),utilisateur.getPassword());



      user.setRole("");
        if(user!=null){
            return user.getNom();
        }else {
           return null;
        }
    }
    @DeleteMapping("delete")
    public void onSaveProduit(@PathParam("id") Long id){

        utilisateurService.delete(id);
    }
   
}
