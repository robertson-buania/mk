package com.example.demo.controllers;

import com.example.demo.entities.Produit;
import com.example.demo.services.ProduitServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("api/produit/")
@CrossOrigin("*")
public class ProduitController {


    private ProduitServiceImpl produitService;

    public ProduitController(ProduitServiceImpl produitService) {
        this.produitService = produitService;
    }

    @GetMapping("all")
    public List<Produit> findAllproduits(){
        return produitService.all();

    }

    @GetMapping("select")
    public Produit findOneProduit(@PathParam("id") int id){

        return produitService.findOne((long) id);

    }
    @PostMapping("save")
    public Produit onSaveProduit(@RequestBody Produit produit){

        return produitService.saveOne(produit);
    }
    @PutMapping("update")
    public Produit onUpdateProduit(@PathParam("id")Long id,@RequestBody Produit produit){
        Produit produit1=produitService.findOne(id);
        produit1.setNom(produit.getNom());
        produit1.setDescription(produit.getDescription());
        produit1.setPrix(produit.getPrix());
        return produitService.saveOne(produit1);
    }
    @DeleteMapping("delete")
    public void onDeleteProduit(@PathParam("id") Long id){

        produitService.delete(id);
    }
   
}
