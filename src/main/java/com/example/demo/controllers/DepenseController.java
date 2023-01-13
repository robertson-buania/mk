package com.example.demo.controllers;

import com.example.demo.entities.Depense;
import com.example.demo.sec.contantes.JWTUtil;
import com.example.demo.services.DepenseServiceImpl;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("api/depense/")
@CrossOrigin(JWTUtil.CORS_ACCESS_PERMITED)
public class DepenseController {


    private DepenseServiceImpl depenseService;

    public DepenseController(DepenseServiceImpl depenseService) {
        this.depenseService = depenseService;
    }

    @GetMapping("all")
    @PostAuthorize("hasAuthority('USER')")
    public List<Depense> findAllDepenses(){
        return depenseService.all();

    }

    @GetMapping("select")
    @PostAuthorize("hasAuthority('USER')")
    public Depense findOneDepense(@PathParam("id") int id){

        return depenseService.findOne((long) id);

    }
    @PostMapping("save")
    @PostAuthorize("hasAuthority('ADMIN')")
    public Depense onSaveVendeuse(@RequestBody Depense depense){
        //System.out.println(depense.getObservationdep() + "motif="+depense.getMotif());
        return depenseService.saveOne(depense);
    }

}
