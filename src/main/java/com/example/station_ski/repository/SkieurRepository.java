package com.example.station_ski.repository;

import com.example.station_ski.entities.Skieur;
import com.example.station_ski.entities.TypeAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface SkieurRepository extends JpaRepository<Skieur,Long> {
    @Query("select s from Skieur s where s.abonnement.typeAbon = ?1")
    List<Skieur> findByAbonnementTypeAbon(TypeAbonnement typeAbonnement);
   @Query("select s from Skieur s order by s.pistes.size")
   List<Skieur> getSkieurByJPQL();
    List<Skieur> findByAbonnementDateFinBetween(LocalDate abonnement_dateFin, LocalDate abonnement_dateFin2);


}
