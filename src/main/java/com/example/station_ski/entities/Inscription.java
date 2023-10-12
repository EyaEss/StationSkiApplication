package com.example.station_ski.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    Long id;
    private int numSemaine;

    @ManyToOne
    @JoinColumn(name = "skieur_id")
    private Skieur skieur;
    @ManyToOne
    @JoinColumn(name = "cours_id")
    private Cours cours;
}
