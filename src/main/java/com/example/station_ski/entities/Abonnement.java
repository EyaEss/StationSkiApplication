package com.example.station_ski.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Getter
@Setter
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    Long id;

    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Float prixAbon;

    @Enumerated(EnumType.STRING)
    private TypeAbonnement typeAbon;


}
