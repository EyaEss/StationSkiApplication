package com.example.station_ski.Service;

import com.example.station_ski.entities.Inscription;
import com.example.station_ski.entities.Skieur;
import com.example.station_ski.repository.InscriptionRepository;
import com.example.station_ski.repository.SkieurRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
@Slf4j //to use logs
@Service
@RequiredArgsConstructor

public class IInscriptionImp implements IInscriptionSevice {
    private final InscriptionRepository inscriptionRepository;
    private final SkieurRepository skieurRepository;

    @Override
    public Inscription addInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);

    }

    @Override
    public void deleteInscription(Long inscriptionId) {

    }

    @Override
    public Inscription updateInscription(Inscription inscription) {
        Assert.isTrue(!inscriptionRepository.existsById(inscription.getId()),"inscription is not found with this id"+inscription.getId());

        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription getInscription(Long inscriptionId) {
            return inscriptionRepository.findById(inscriptionId).orElse(null);
    }

    @Override
    public List<Inscription> getAllInscription() {
        return (List)inscriptionRepository.findAll();
    }

    /* AJOUT SIMPLE*/
    @Override
    public Inscription addInscriptionAndAssignToSkier(Inscription inscription, Long id) {
       Skieur skieur= skieurRepository.findById(id).orElse(null);
       inscription.setSkieur(skieur);
        return inscriptionRepository.save(inscription);
    }
    @Scheduled(cron ="10" )
    @Override
    public void testscheduled() {
        log.info("yo this is shit");
    }
}
