package com.example.station_ski.repository;

import com.example.station_ski.entities.Abonnement;
import com.example.station_ski.entities.Cours;
import com.example.station_ski.entities.Skieur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {
    List<Abonnement> findByDateFinBetween(LocalDate dateDebut, LocalDate dateFin);
}
