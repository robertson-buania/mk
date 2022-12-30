package com.example.demo.controllers;

import net.buania.mkprodback.dao.ProduitRepository;
import net.buania.mkprodback.dto.Livraisondto;
import net.buania.mkprodback.entities.Livraison;
import net.buania.mkprodback.services.LivraisonServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/livraison/")
@CrossOrigin("*")
public class LivraisonController {


    private LivraisonServiceImpl livraisonService;
    private ProduitRepository produitService;
    public LivraisonController(LivraisonServiceImpl livraisonService,ProduitRepository produitService ) {
        this.livraisonService = livraisonService;
        this.produitService=produitService;
    }

    @GetMapping("all")
    public List<Livraisondto> findAllLivraisons(){
        List<Livraisondto> livraisondtoList=new ArrayList<>();
        livraisonService.all().forEach(liv -> {
            Livraisondto livraison=new Livraisondto();
            livraison.setId(liv.getId());
            livraison.setBonlivraison(liv.getBonlivraison());
            livraison.setDestination(liv.getDestination());
            livraison.setDatecreation(liv.getDatecreation());
            livraison.setLieuvente(liv.getLieuvente());
            livraison.setNomclient(liv.getDestination());
            livraison.setPlaque(liv.getPlaque());
            livraison.setPoidsbrute(liv.getPoidsbrute());
            livraison.setPoidsnet(liv.getPoidsnet());
            livraison.setPoidstare(liv.getPoidstare());
            livraison.setTelclient(liv.getTelclient());
            livraison.setProduit(liv.getProduit().getNom());
            livraisondtoList.add(livraison);
        });
        return livraisondtoList;

    }

    @GetMapping("select")
    public Livraisondto findOneLivraison(@PathParam("id") int id){
        Livraison liv=livraisonService.findOne((long)id);
        Livraisondto livraison=new Livraisondto();
        livraison.setId(liv.getId());
        livraison.setBonlivraison(liv.getBonlivraison());
        livraison.setDestination(liv.getDestination());
        livraison.setDatecreation(liv.getDatecreation());
        livraison.setLieuvente(liv.getLieuvente());
        livraison.setNomclient(liv.getDestination());
        livraison.setPlaque(liv.getPlaque());
        livraison.setPoidsbrute(liv.getPoidsbrute());
        livraison.setPoidsnet(liv.getPoidsnet());
        livraison.setPoidstare(liv.getPoidstare());
        livraison.setTelclient(liv.getTelclient());
        livraison.setProduit(liv.getProduit().getNom());

        return livraison;

    }
    @PostMapping("save")
    public Livraison onSaveLivraison(@RequestBody Livraisondto livraisondto){
        Livraison livraison=new Livraison();

        livraison.setBonlivraison(livraisondto.getBonlivraison());
        livraison.setDestination(livraisondto.getDestination());
        livraison.setDatecreation(livraisondto.getDatecreation());
        livraison.setLieuvente(livraisondto.getLieuvente());
        livraison.setNumclient(livraisondto.getNomclient());
        livraison.setPlaque(livraisondto.getPlaque());
        livraison.setPoidsbrute(livraisondto.getPoidsbrute());
        livraison.setPoidsnet(livraisondto.getPoidsnet());
        livraison.setPoidstare(livraisondto.getPoidstare());
        livraison.setTelclient(livraisondto.getTelclient());
        livraison.setProduit(produitService.findDistinctByNomContains(livraisondto.getProduit()));
        return livraisonService.saveOne(livraison);
    }

   
}
