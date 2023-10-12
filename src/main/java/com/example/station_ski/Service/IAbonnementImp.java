package com.example.station_ski.Service;

import com.example.station_ski.entities.Abonnement;
import com.example.station_ski.repository.AbonnementRepository;
import com.example.station_ski.repository.CoursRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
@Service
@RequiredArgsConstructor
public class IAbonnementImp implements IAbonnementService{
    private final AbonnementRepository abonnementRepository;

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
}
