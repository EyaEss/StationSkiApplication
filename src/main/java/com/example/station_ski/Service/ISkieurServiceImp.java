package com.example.station_ski.Service;

import com.example.station_ski.entities.*;
import com.example.station_ski.repository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Primary
@Service
@RequiredArgsConstructor
public class ISkieurServiceImp implements ISkieurService {
    @Autowired
    private final SkieurRepository skieurRepository;
    private final PisteRepository pisteRepository;
    private final CoursRepository coursRepository ;
    private final InscriptionRepository inscriptionRepository ;
    private final AbonnementRepository abonnementRepository ;



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

    @Transactional
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

    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skieur, Long numCourse) {
        Cours course = coursRepository.findById(numCourse).orElse(null);

        if (course != null) {

            Inscription inscription = skieur.getInscriptions().get(0);
            Abonnement abonnement = skieur.getAbonnement();
            skieurRepository.save(skieur);

            inscription.setSkieur(skieur);
            inscription.setCours(course);

            inscriptionRepository.save(inscription);

           // course.getInscriptions().add(inscription);
          //  coursRepository.save(course);

          /*  Abonnement abonnement = new Abonnement();
           // skieur.setAbonnement(abonnement);
            //abonnementRepository.save(abonnement);
            skieur.setAbonnement(abonnement);
            skieurRepository.save(skieur);*/
        } else {
            throw new EntityNotFoundException("Course not found with id: " + numCourse);
        }
        return skieur;
    }

    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        List<Skieur> skieurList =(List<Skieur>) this.skieurRepository.findAll();
        List<Skieur>skieurList1 = new ArrayList<>();
        skieurList.forEach(skieur -> {
            if(skieur.getAbonnement().getTypeAbon().equals(typeAbonnement)){
                skieurList1.add(skieur);
            }
        });
        return skieurList1;
    }


}
