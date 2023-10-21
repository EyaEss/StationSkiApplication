package com.example.station_ski.Service;

import com.example.station_ski.entities.Skieur;
import com.example.station_ski.entities.TypeAbonnement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ISkieurServiceImp2 implements ISkieurService{
    @Override
    public Skieur addSkieur(Skieur skieur) {
        return null;
    }

    @Override
    public void deleteSkieur(Long skieurId) {

    }

    @Override
    public Skieur updateSkieur(Skieur skieur) {
        return null;
    }

    @Override
    public Skieur getSkieur(Long skieurId) {
        return null;
    }

    @Override
    public List<Skieur> getAllSkieurs() {
        return null;
    }

    @Override
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste) {
        return null;
    }

    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skieur, Long numCourse) {
        return null;
    }

    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        return null;
    }
}
