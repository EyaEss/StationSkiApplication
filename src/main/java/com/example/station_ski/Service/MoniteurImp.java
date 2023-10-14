package com.example.station_ski.Service;

import com.example.station_ski.entities.Cours;
import com.example.station_ski.entities.Moniteur;
import com.example.station_ski.entities.Skieur;
import com.example.station_ski.repository.CoursRepository;
import com.example.station_ski.repository.MoniteurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.*;

@Service
@RequiredArgsConstructor

public class MoniteurImp implements IMoniteur {
    private final MoniteurRepository moniteurRepository;
    private final CoursRepository coursRepository;

    @Override
    public Moniteur addMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur) ;
    }

    @Override
    public void deleteMoniteur(Long moniteurId) {
            moniteurRepository.deleteById(moniteurId);
    }

    @Override
    public Moniteur updateMoniteur(Moniteur moniteur) {
        Assert.isTrue(!moniteurRepository.existsById(moniteur.getId()),"Moniteur not found with this id"+moniteur.getId());

        return moniteurRepository.save(moniteur);
    }

    @Override
    public Moniteur getMoniteur(Long moniteurId) {
        return moniteurRepository.findById(moniteurId).orElse(null);

    }

    @Override
    public List<Moniteur> getAllMoniteur() {
        return (List)moniteurRepository.findAll();

    }

    @Override
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse) {
        Cours cours = coursRepository.findById(numCourse).orElse(null);
        //list, moniteur obejct jdid

        Moniteur existingMoniteur = moniteurRepository.findById(numCourse).orElse(null);

        if (existingMoniteur == null) {
            return null;
        }

        List<Cours> coursSet = new ArrayList<>();
        coursSet.add(cours);
        moniteur.setCoursList(coursSet);

        return moniteurRepository.save(moniteur);
    }

}
