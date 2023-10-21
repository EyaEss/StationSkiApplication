package com.example.station_ski.Service;

import com.example.station_ski.entities.Abonnement;
import com.example.station_ski.entities.Skieur;
import com.example.station_ski.repository.AbonnementRepository;
import com.example.station_ski.repository.CoursRepository;
import com.example.station_ski.repository.SkieurRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;
@Service
@Slf4j
@RequiredArgsConstructor
public class IAbonnementImp implements IAbonnementService{

    private final AbonnementRepository abonnementRepository;
    private final SkieurRepository skieurRepository;

    @Override
    public Abonnement addAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);

    }

    @Override
    public void deleteAbonnement(Long abonnementId) {
        abonnementRepository.deleteById(abonnementId);
    }

    @Override
    public Abonnement updateAbonnement(Abonnement abonnement) {
        Assert.isTrue(!abonnementRepository.existsById(abonnement.getId()),"abonnement not found with this id"+abonnement.getId());

        return abonnementRepository.save(abonnement);
    }

    @Override
    public Abonnement getAbonnement(Long abonnementId) {
        return abonnementRepository.findById(abonnementId).orElse(null);

    }

    @Override
    public List<Abonnement> getAllAbonnement() {
        return (List)abonnementRepository.findAll();

    }
    @Scheduled()
    void retrieveSubscriptions(){
        LocalDate dateToday = LocalDate.now();
        LocalDate datenextweek= dateToday.plusDays(7);
        List<Skieur> Listskieur = skieurRepository.findByAbonnementDateFinBetween(dateToday,datenextweek);
      //  List<Abonnement> ListAbn = abonnementRepository.findByDateFinBetween(dateToday,datenextweek);
        Listskieur.forEach(skieur ->log.info("abonnement"+ skieur.getAbonnement() +  skieur.getNomS()  );

    }
}
