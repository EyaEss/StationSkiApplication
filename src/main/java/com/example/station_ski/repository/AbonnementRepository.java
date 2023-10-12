package com.example.station_ski.repository;

import com.example.station_ski.entities.Abonnement;
import com.example.station_ski.entities.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {
}
