package com.example.station_ski.Controller;

import com.example.station_ski.Service.ICoursService;
import com.example.station_ski.Service.ISkieurService;
import com.example.station_ski.entities.Cours;
import com.example.station_ski.entities.Skieur;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cours")
@RequiredArgsConstructor
public class CoursController {
    private final ICoursService coursService;
    @PostMapping()
    public Cours addCours(@RequestBody Cours cours){
       return coursService.addCours(cours);
    }
  /*  @GetMapping("{s}")
   public String helloword(@PathVariable String s){

        return "THIS SHIT WORKS"+s;}*/

    @GetMapping("{id}")
    public Cours getCours(@PathVariable Long id) {
        return coursService.getCours(id);
    }
    @GetMapping
    public List<Cours> getAllCours() {
        return coursService.getAllCours();
    }



    @PutMapping
    public Cours updateCours( @RequestBody Cours updatedCours) {
        return coursService.updateCours(updatedCours);
    }

    @DeleteMapping("{id}")
    public void deleteCours(@PathVariable Long id) {
        coursService.deleteCours(id);
    }
}
