package com.example.demo.controllers;
import net.buania.mkprodback.dao.EnginRepository;
import net.buania.mkprodback.dto.Consommationdto;
import net.buania.mkprodback.entities.Consommationmazout;
import net.buania.mkprodback.entities.Engin;
import net.buania.mkprodback.services.ConsommationmazoutServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/consommationmazout/")
@CrossOrigin("*")
public class ConsommationmazoutController {


    private ConsommationmazoutServiceImpl consommationmazoutService;
    private  EnginRepository enginRepository;
    public ConsommationmazoutController(EnginRepository enginRepository,ConsommationmazoutServiceImpl consommationmazoutService) {
        this.consommationmazoutService = consommationmazoutService;
        this. enginRepository=enginRepository;
    }

    @GetMapping("all")
    public List<Consommationdto> findAllConsommationmazoutes(){
        List<Consommationdto> consommationdtos=new ArrayList<>();
        consommationmazoutService.all().forEach(consommationmazout -> {
            Consommationdto consommationdto=new Consommationdto();
            consommationdto.setHeurechargement(consommationmazout.getHeurechargement());
            consommationdto.setDatecreation(consommationmazout.getDatecreation());
            consommationdto.setNombrelitre(consommationmazout.getNombrelitre());
            consommationdto.setPeriodedebut(consommationmazout.getPeriodedebut());
            consommationdto.setPeriodefin(consommationmazout.getPeriodefin());
            consommationdto.setEngin(consommationmazout.getEngin().getNom());
            consommationdtos.add(consommationdto);
        });
        return consommationdtos;

    }

    @GetMapping("select")
    public Consommationmazout findOneConsommationmazout(@PathParam("id") int id){

        return consommationmazoutService.findOne((long) id);

    }
    @PostMapping("save")
    public Consommationmazout onSaveConsommationmazout(@RequestBody Consommationdto consommationdto){

        Consommationmazout consommationmazout=new Consommationmazout();

        Engin engin=enginRepository.findDistinctByNomContains(consommationdto.getEngin());
        consommationmazout.setDatecreation(new Date());
        consommationmazout.setHeurechargement(consommationdto.getHeurechargement());
        consommationmazout.setNombrelitre(consommationdto.getNombrelitre());
        consommationmazout.setPeriodedebut(consommationdto.getPeriodedebut());
        consommationmazout.setPeriodefin(consommationdto.getPeriodefin());
        if(engin!=null){
            consommationmazout.setEngin(engin);
        }

        return consommationmazoutService.saveOne(consommationmazout);
    }
    @DeleteMapping("delete")
    public void onSaveConsommationmazout(@PathParam("id") Long id){

         consommationmazoutService.delete(id);
    }
   
}
