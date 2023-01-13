package com.example.demo.controllers;
import com.example.demo.dao.EnginRepository;
import com.example.demo.dto.Consommationdto;
import com.example.demo.entities.Consommationmazout;
import com.example.demo.entities.Engin;
import com.example.demo.sec.contantes.JWTUtil;
import com.example.demo.services.ConsommationmazoutServiceImpl;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/consommationmazout/")
@CrossOrigin(JWTUtil.CORS_ACCESS_PERMITED)
public class ConsommationmazoutController {


    private ConsommationmazoutServiceImpl consommationmazoutService;
    private EnginRepository enginRepository;
    public ConsommationmazoutController(EnginRepository enginRepository,ConsommationmazoutServiceImpl consommationmazoutService) {
        this.consommationmazoutService = consommationmazoutService;
        this. enginRepository=enginRepository;
    }

    @GetMapping("all")
    @PostAuthorize("hasAuthority('USER')")
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
    @PostAuthorize("hasAuthority('USER')")
    public Consommationmazout findOneConsommationmazout(@PathParam("id") int id){

        return consommationmazoutService.findOne((long) id);

    }
    @PostMapping("save")
    @PostAuthorize("hasAuthority('ADMIN')")
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
    @PostAuthorize("hasAuthority('ADMIN')")
    public void onSaveConsommationmazout(@PathParam("id") Long id){

         consommationmazoutService.delete(id);
    }
   
}
