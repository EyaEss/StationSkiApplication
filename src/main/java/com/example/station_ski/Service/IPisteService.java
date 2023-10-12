package com.example.station_ski.Service;

import com.example.station_ski.entities.Piste;

import java.util.List;

public interface IPisteService {
    public Piste addPiste(Piste piste);
    public String deletePiste (Long pisteId);
    public Piste updatePiste( Piste piste);
    public Piste getPiste(Long pisteId);
    public List<Piste> getAllPiste();
}
