package com.example.station_ski.Controller;

import com.example.station_ski.Service.IAbonnementService;
import com.example.station_ski.entities.Abonnement;
import com.example.station_ski.entities.Cours;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("abonnement")
@RequiredArgsConstructor
public class AbonnementController {
    private final IAbonnementService abonnementService;

    @PostMapping()
    public Abonnement addAbonnement(@RequestBody Abonnement abonnement){
        return abonnementService.addAbonnement(abonnement);
    }
    @GetMapping("{id}")
    public Abonnement getAbonnement(@PathVariable Long id) {
        return abonnementService.getAbonnement(id);
    }
    @GetMapping
    public List<Abonnement> getAllAbonnement() {
        return abonnementService.getAllAbonnement();
    }
    @PutMapping
    public Abonnement updateAbonnement( @RequestBody Abonnement updatedAbonnement) {
        return abonnementService.updateAbonnement(updatedAbonnement);

    }

    @DeleteMapping("{id}")
    public void deleteAbonnement(@PathVariable Long id) {
        abonnementService.deleteAbonnement(id);
    }

}
