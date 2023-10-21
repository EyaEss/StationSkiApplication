package com.example.station_ski.Service;

import com.example.station_ski.entities.Skieur;
import com.example.station_ski.entities.TypeAbonnement;

import java.util.List;

public interface ISkieurService {
    public Skieur addSkieur(Skieur skieur);
    public void  deleteSkieur (Long skieurId);
    public Skieur updateSkieur( Skieur skieur);
    public Skieur getSkieur(Long skieurId);
    public List<Skieur> getAllSkieurs();


    Skieur assignSkierToPiste(Long numSkieur, Long numPiste);

    Skieur addSkierAndAssignToCourse(Skieur skieur, Long numCourse);
    List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement);
}
