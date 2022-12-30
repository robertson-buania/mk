package com.example.demo.controllers;

import net.buania.mkprodback.entities.Utilisateur;
import net.buania.mkprodback.services.UtilisateurServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("api/utilisateur/")
@CrossOrigin("*")
public class UtilisateurController {


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
    @PostMapping("save")
    public Utilisateur onSaveProduit(@RequestBody Utilisateur utilisateur){

        return utilisateurService.saveOne(utilisateur);
    }
    @DeleteMapping("delete")
    public void onSaveProduit(@PathParam("id") Long id){

        utilisateurService.delete(id);
    }
   
}
