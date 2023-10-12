package com.example.station_ski.Service;

import com.example.station_ski.entities.Skieur;

import java.util.List;

public interface ISkieurService {
    public Skieur addSkieur(Skieur skieur);
    public void  deleteSkieur (Long skieurId);
    public Skieur updateSkieur( Skieur skieur);
    public Skieur getSkieur(Long skieurId);
    public List<Skieur> getAllSkieurs();








}
