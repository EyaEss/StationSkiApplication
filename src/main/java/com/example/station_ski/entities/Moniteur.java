package com.example.station_ski.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
public class Moniteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    Long id;


    private String nomM;
    private String prenomM;
    private LocalDate dateRecru;
    private String gestion;

    @OneToMany
    private List<Cours> coursList;
}
