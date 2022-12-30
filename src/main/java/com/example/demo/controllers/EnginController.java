package com.example.demo.controllers;

import net.buania.mkprodback.dao.ConsommationmazoutRepository;
import net.buania.mkprodback.dto.Engindto;
import net.buania.mkprodback.entities.Consommationmazout;
import net.buania.mkprodback.entities.Engin;
import net.buania.mkprodback.services.EnginServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/engin/")
@CrossOrigin("*")
public class EnginController {


    private EnginServiceImpl enginServicee;
    private ConsommationmazoutRepository consommationmazoutRepository;

    public EnginController(EnginServiceImpl enginServicee, ConsommationmazoutRepository consommationmazoutRepository) {
        this.enginServicee = enginServicee;
        this.consommationmazoutRepository = consommationmazoutRepository;
    }

    @GetMapping("all")
    public List<Engindto> findAllEngins(){
        List<Engindto> engindtos=new ArrayList<>();
        enginServicee.all().forEach(engin -> {
            Engindto engindto=new Engindto();
            engindto.setDescription(engin.getDescription());
            engindto.setNom(engin.getNom());
          Consommationmazout consommationmazout= consommationmazoutRepository.findDistinctFirstByEngin_Nom(engin.getNom());
          engindto.setDerniereConsommation(consommationmazout.getNombrelitre());
          engindto.setDerniereDate(consommationmazout.getDatecreation());
          engindtos.add(engindto);

        });
        return engindtos;

    }

    @GetMapping("select")
    public Engin findOneEngin(@PathParam("id") int id){

        return enginServicee.findOne((long) id);

    }
    @PostMapping("save")
    public Engin onSaveProduit(@RequestBody Engin engin){

        return enginServicee.saveOne(engin);
    }

   
}