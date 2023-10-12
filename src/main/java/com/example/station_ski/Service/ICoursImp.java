package com.example.station_ski.Service;

import com.example.station_ski.entities.Cours;
import com.example.station_ski.repository.CoursRepository;
import com.example.station_ski.repository.SkieurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ICoursImp implements ICoursService{

    private final CoursRepository coursRepository;
    @Override
    public Cours addCours(Cours cours) {

        return  coursRepository.save(cours);
    }

    @Override
    public void deleteCours(Long coursId) {

        coursRepository.deleteById(coursId);
    }

    @Override
    public Cours updateCours(Cours cours) {
        Assert.isTrue(!coursRepository.existsById(cours.getId()),"cours not found with this id"+cours.getId());

        return coursRepository.save(cours);
    }

    @Override
    public Cours getCours(Long coursId) {
        return coursRepository.findById(coursId).orElse(null);
    }

    @Override
    public List<Cours> getAllCours() {
        return (List)coursRepository.findAll();
        //return coursRepository.findById(idC)
    }
}
