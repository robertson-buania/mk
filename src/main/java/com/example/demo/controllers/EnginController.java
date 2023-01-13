package com.example.demo.controllers;

import com.example.demo.dao.ConsommationmazoutRepository;
import com.example.demo.dto.Engindto;
import com.example.demo.entities.Consommationmazout;
import com.example.demo.entities.Engin;
import com.example.demo.sec.contantes.JWTUtil;
import com.example.demo.services.EnginServiceImpl;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/engin/")
@CrossOrigin(JWTUtil.CORS_ACCESS_PERMITED)
public class EnginController {


    private EnginServiceImpl enginServicee;
    private ConsommationmazoutRepository consommationmazoutRepository;

    public EnginController(EnginServiceImpl enginServicee, ConsommationmazoutRepository consommationmazoutRepository) {
        this.enginServicee = enginServicee;
        this.consommationmazoutRepository = consommationmazoutRepository;
    }

    @GetMapping("all")
    @PostAuthorize("hasAuthority('USER')")
    public List<Engindto> findAllEngins(){
        List<Engindto> engindtos=new ArrayList<>();
        enginServicee.all().forEach(engin -> {
            Engindto engindto=new Engindto();
            engindto.setDescription(engin.getDescription());
            engindto.setNom(engin.getNom());
          Consommationmazout consommationmazout= consommationmazoutRepository.findDistinctFirstByEngin_Nom(engin.getNom());
          if(consommationmazout!=null){
              engindto.setDerniereConsommation(consommationmazout.getNombrelitre());
              engindto.setDerniereDate(consommationmazout.getDatecreation());
          }

          engindtos.add(engindto);

        });
        return engindtos;

    }

    @GetMapping("select")
    @PostAuthorize("hasAuthority('USER')")
    public Engin findOneEngin(@PathParam("id") int id){

        return enginServicee.findOne((long) id);

    }
    @PostMapping("save")
    @PostAuthorize("hasAuthority('ADMIN')")
    public Engin onSaveProduit(@RequestBody Engin engin){

        return enginServicee.saveOne(engin);
    }

   
}
