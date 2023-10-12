package com.example.station_ski.Controller;

import com.example.station_ski.Service.ICoursService;
import com.example.station_ski.Service.IPisteService;
import com.example.station_ski.entities.Cours;
import com.example.station_ski.entities.Piste;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("piste")
@RequiredArgsConstructor
public class PisteController {
    private final IPisteService pisteService;

    @PostMapping()
    public Piste addPiste(@RequestBody Piste piste){
        System.out.println("Received POST request to add Piste: " + piste.toString());
        return pisteService.addPiste(piste);
    }
    @GetMapping("{id}")
    public Piste getPiste(@PathVariable Long id) {
        return pisteService.getPiste(id);
    }
    @GetMapping
    public List<Piste> getAllPiste() {
        return pisteService.getAllPiste();
    }
    @PutMapping
    public Piste updatePiste( @RequestBody Piste updatedPiste) {
        return pisteService.updatePiste(updatedPiste);
    }
    @DeleteMapping("{id}")
    public void deletePiste(@PathVariable Long id) {
        pisteService.deletePiste(id);
    }

}
