package com.example.station_ski.Service;

import com.example.station_ski.entities.Cours;
import com.example.station_ski.entities.Skieur;

import java.util.List;

public interface ICoursService {
    public Cours addCours(Cours cours);
    public void  deleteCours (Long coursId);
    public Cours updateCours( Cours cours);
    public Cours getCours(Long coursId);
    public List<Cours> getAllCours();
}
