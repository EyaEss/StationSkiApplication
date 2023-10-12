package com.example.station_ski.repository;

import com.example.station_ski.entities.Cours;
import com.example.station_ski.entities.Piste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PisteRepository extends JpaRepository<Piste,Long> {

}
