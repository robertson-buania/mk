package com.example.demo.controllers;

import net.buania.mkprodback.entities.Mazout;
import net.buania.mkprodback.services.MazoutServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("api/mazout/")
@CrossOrigin("*")
public class MazoutController {


    private MazoutServiceImpl mazoutService;

    public MazoutController(MazoutServiceImpl mazoutService) {
        this.mazoutService = mazoutService;
    }

    @GetMapping("all")
    public List<Mazout> findAllConsommationmazoutes(){
        return mazoutService.all();

    }

    @GetMapping("select")
    public Mazout findOneConsommationmazout(@PathParam("id") int id){

        return mazoutService.findOne((long) id);

    }
    @PostMapping("save")
    public Mazout onSaveConsommationmazout(@RequestBody Mazout mazout){

        return mazoutService.saveOne(mazout);
    }

   
}
