package com.example.station_ski.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity

public class Piste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    Long id;
    String nomPiste;
    @Enumerated(EnumType.STRING)
    Couleur couleur;
    int Longeur;
    int pente;

    @ManyToMany
   // @JoinTable(
          //  name = "skieur_piste",
        //    joinColumns = @JoinC olumn(name = "piste_id"),
      //      inverseJoinColumns = @JoinColumn(name = "skieur_id")
   // )
    private Set<Skieur> skieurs;

}
