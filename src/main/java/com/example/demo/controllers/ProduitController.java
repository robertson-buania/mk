package com.example.demo.controllers;

import com.example.demo.entities.Produit;
import com.example.demo.sec.contantes.JWTUtil;
import com.example.demo.services.ProduitServiceImpl;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("api/produit/")
@CrossOrigin(JWTUtil.CORS_ACCESS_PERMITED)
public class ProduitController {


    private ProduitServiceImpl produitService;

    public ProduitController(ProduitServiceImpl produitService) {
        this.produitService = produitService;
    }

    @GetMapping("all")
    @PostAuthorize("hasAuthority('USER')")
    public List<Produit> findAllproduits(){
        return produitService.all();

    }

    @GetMapping("select")
    @PostAuthorize("hasAuthority('USER')")
    public Produit findOneProduit(@PathParam("id") int id){
        //IllegalStateException
        return produitService.findOne((long) id);

    }
    @GetMapping("selectedname")
    @PostAuthorize("hasAuthority('USER')")
    public ProduitdtoLiv findOneByNameProduit(@PathParam("nom") String nom){
        //IllegalStateException

        Produit produit=produitService.findOneByName(nom);
        ProduitdtoLiv produitdtoLiv=new ProduitdtoLiv();
        produitdtoLiv.setId(produit.getId());
        produitdtoLiv.setNom(produit.getNom());
        produitdtoLiv.setPrix(produit.getPrix());
        return produitdtoLiv;

    }
    @PostMapping("save")
    @PostAuthorize("hasAuthority('ADMIN')")
    public Produit onSaveProduit(@RequestBody Produit produit){

        return produitService.saveOne(produit);
    }
    @PutMapping("update")
    @PostAuthorize("hasAuthority('ADMIN')")
    public Produit onUpdateProduit(@PathParam("id")Long id,@RequestBody Produit produit){
        Produit produit1=produitService.findOne(id);
        produit1.setNom(produit.getNom());
        produit1.setDescription(produit.getDescription());
        produit1.setPrix(produit.getPrix());
        return produitService.saveOne(produit1);
    }
    @DeleteMapping("delete")
    @PostAuthorize("hasAuthority('ADMIN')")
    public void onDeleteProduit(@PathParam("id") Long id){

        produitService.delete(id);
    }
   
}

class ProduitdtoLiv{
    private Long id;
    private String nom;
    private Double prix;

    public ProduitdtoLiv() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }
}