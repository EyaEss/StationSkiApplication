package com.example.station_ski.Service;

import com.example.station_ski.entities.Moniteur;
import com.example.station_ski.entities.Skieur;

import java.util.List;

public interface IMoniteur {
    public Moniteur addMoniteur(Moniteur moniteur);
    public void  deleteMoniteur (Long moniteurId);
    public Moniteur updateMoniteur( Moniteur moniteur);
    public Moniteur getMoniteur(Long moniteurId);
    public List<Moniteur> getAllMoniteur();
}
