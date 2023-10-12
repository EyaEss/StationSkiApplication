package com.example.station_ski.repository;

import com.example.station_ski.entities.Moniteur;
import org.springframework.boot.autoconfigure.jackson.JacksonProperties;
import org.springframework.data.repository.CrudRepository;

public interface MoniteurRepository extends CrudRepository<Moniteur,Long> {
}
