package com.example.station_ski.Controller;

import com.example.station_ski.Service.IInscriptionSevice;
import com.example.station_ski.entities.Cours;
import com.example.station_ski.entities.Inscription;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inscription")
public class InscriptionController {
    private final IInscriptionSevice inscriptionService;

    public InscriptionController(IInscriptionSevice inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    @PostMapping()
    public Inscription addInscription(@RequestBody Inscription inscription){
        return inscriptionService.addInscription(inscription);
    }
    @GetMapping("{id}")
    public Inscription getInscription(@PathVariable Long id) {
        return inscriptionService.getInscription(id);
    }
    @GetMapping
    public List<Inscription> getAllInscription() {
        return inscriptionService.getAllInscription();
    }
    @PutMapping
    public Inscription updateInscription( @RequestBody Inscription updatedInscription) {
        return inscriptionService.updateInscription(updatedInscription);
    }

    @DeleteMapping("{id}")
    public String deleteInscription(@PathVariable Long id) {
        inscriptionService.deleteInscription(id);
        return "inscription is deleted successfully";
    }
    @PostMapping("{id}")
    public Inscription addInscriptionAndAssignToSkier(@RequestBody Inscription inscription, @PathVariable Long id){
        return inscriptionService.addInscriptionAndAssignToSkier(inscription,id);
    }

}
