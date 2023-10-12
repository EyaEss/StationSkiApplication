package com.example.station_ski.Service;

import com.example.station_ski.entities.Skieur;
import com.example.station_ski.repository.SkieurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
@Primary
@Service
public class ISkieurServiceImp implements ISkieurService {
    @Autowired
    private SkieurRepository skieurRepository;
    @Override
    public Skieur addSkieur(Skieur skieur) {
        return skieurRepository.save(skieur);


    }

    @Override
    public void deleteSkieur(Long skieurId) {
        skieurRepository.deleteById(skieurId);
    }

    @Override
    public Skieur updateSkieur(Skieur skieur) {
        Assert.isTrue(!skieurRepository.existsById(skieur.getId()),"skieur is not found with this id"+skieur.getId());

        return skieurRepository.save(skieur);
    }

    @Override
    public Skieur getSkieur(Long skieurId) {

        return skieurRepository.findById(skieurId).orElse(null);
    }

    @Override
    public List<Skieur> getAllSkieurs() {

        return (List)skieurRepository.findAll();
    }

}
