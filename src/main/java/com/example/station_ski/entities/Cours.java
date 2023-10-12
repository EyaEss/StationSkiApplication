package com.example.station_ski.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    Long id;
    private int niveau;

    @Enumerated(EnumType.STRING) // Specify that it's an enum
    private TypeCours typeCours;

    @Enumerated(EnumType.STRING) // Specify that it's an enum
    private Support support;

    private Float prix;
    private int creneau;
    @OneToMany(mappedBy = "cours", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inscription> inscriptions;
}
