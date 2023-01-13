package com.example.demo.controllers;

import com.example.demo.entities.Mazout;
import com.example.demo.sec.contantes.JWTUtil;
import com.example.demo.services.MazoutServiceImpl;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("api/mazout/")
@CrossOrigin(JWTUtil.CORS_ACCESS_PERMITED)
public class MazoutController {


    private MazoutServiceImpl mazoutService;

    public MazoutController(MazoutServiceImpl mazoutService) {
        this.mazoutService = mazoutService;
    }

    @GetMapping("all")
    @PostAuthorize("hasAuthority('USER')")
    public List<Mazout> findAllConsommationmazoutes(){
        return mazoutService.all();

    }

    @GetMapping("select")
    @PostAuthorize("hasAuthority('USER')")
    public Mazout findOneConsommationmazout(@PathParam("id") int id){

        return mazoutService.findOne((long) id);

    }
    @PostMapping("save")
    @PostAuthorize("hasAuthority('ADMIN')")
    public Mazout onSaveConsommationmazout(@RequestBody Mazout mazout){

        return mazoutService.saveOne(mazout);
    }

   
}
