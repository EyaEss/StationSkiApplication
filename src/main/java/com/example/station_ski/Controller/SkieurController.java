package com.example.station_ski.Controller;

import com.example.station_ski.Service.ISkieurService;
import com.example.station_ski.Service.ISkieurService;
import com.example.station_ski.Service.ISkieurServiceImp;
import com.example.station_ski.entities.Skieur;
import com.example.station_ski.entities.Skieur;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("skieurs")
@RestController
@RequiredArgsConstructor
public class SkieurController {
    private final ISkieurService skieurService;
    @PostMapping()
    public Skieur addSkieur(@RequestBody Skieur skieur){
        return skieurService.addSkieur(skieur);
    }

    @GetMapping("{id}")
    public Skieur getSkieur(@PathVariable Long id) {
        return skieurService.getSkieur(id);
    }
    @GetMapping
    public List<Skieur> getAllSkieur() {
        return skieurService.getAllSkieurs();
    }


    @PutMapping("{id}")
    public Skieur updateSkieur(@PathVariable Long id, @RequestBody Skieur updatedSkieur) {
        Skieur existingSkieur = skieurService.getSkieur(id);

        if (existingSkieur == null) {
            return null;
        }

        return skieurService.updateSkieur(existingSkieur);
    }

    @DeleteMapping("{id}")
    public void deleteSkieur(@PathVariable Long id) {
        skieurService.deleteSkieur(id);
    }
}
