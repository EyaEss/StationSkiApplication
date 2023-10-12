package com.example.station_ski.Service;
import com.example.station_ski.entities.Cours;
import com.example.station_ski.entities.Piste;
import com.example.station_ski.repository.PisteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
@Service
@RequiredArgsConstructor
public class IPisteImp implements IPisteService {
    private final PisteRepository pisteRepository;
    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepository.save(piste);

    }

    @Override
    public String deletePiste(Long pisteId) {
        pisteRepository.deleteById(pisteId);
        return "this Piste is deleted";

    }

    @Override
    public Piste updatePiste(Piste piste) {
        Assert.isTrue(!pisteRepository.existsById(piste.getId()),"piste not found with this id"+piste.getId());

        return pisteRepository.save(piste);
    }

    @Override
    public Piste getPiste(Long pisteId) {
        return pisteRepository.findById(pisteId).orElse(null);
    }

    @Override
    public List<Piste> getAllPiste() {
        return (List)pisteRepository.findAll();


    }
}
