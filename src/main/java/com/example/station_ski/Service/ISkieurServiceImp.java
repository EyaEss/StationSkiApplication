package com.example.station_ski.Service;

import com.example.station_ski.entities.Piste;
import com.example.station_ski.entities.Skieur;
import com.example.station_ski.repository.PisteRepository;
import com.example.station_ski.repository.SkieurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Set;

@Primary
@Service
public class ISkieurServiceImp implements ISkieurService {
    @Autowired
    private SkieurRepository skieurRepository;
    private  PisteRepository pisteRepository;



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

    @Override
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste) {
        Piste piste = pisteRepository.findById(numPiste).orElse(null);
        Skieur skieur = skieurRepository.findById(numSkieur).orElse(null);
        Set<Skieur> skieurSet =piste.getSkieurs();
        skieurSet.add(skieur);
        piste.setSkieurs(skieurSet);
        //kif njib mil base de donnees
        piste.getSkieurs().add(skieur);
        pisteRepository.save(piste);
        return null;
    }

}
