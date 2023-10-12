package com.example.station_ski.Service;

import com.example.station_ski.entities.Abonnement;

import java.util.List;

public interface IAbonnementService {
    public Abonnement addAbonnement(Abonnement abonnement);
    public void  deleteAbonnement (Long abonnementId);
    public Abonnement updateAbonnement( Abonnement abonnement);
    public Abonnement getAbonnement(Long abonnementId);
    public List<Abonnement> getAllAbonnement();
}
