package com.example.station_ski.Controller;

import com.example.station_ski.Service.ICoursService;
import com.example.station_ski.Service.IMoniteur;
import com.example.station_ski.entities.Cours;
import com.example.station_ski.entities.Moniteur;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("moniteur")
@RequiredArgsConstructor
public class MoniteurContoller {
    private final IMoniteur moniteurService;
    @PostMapping()
    public Moniteur addMoniteur(@RequestBody Moniteur moniteur){

        return moniteurService.addMoniteur(moniteur);
    }
    @GetMapping("{id}")
    public Moniteur getMoniteur(@PathVariable Long id) {
        return moniteurService.getMoniteur(id);
    }
    @GetMapping
    public List<Moniteur> getAllMoniteur() {
        return moniteurService.getAllMoniteur();
    }


}
