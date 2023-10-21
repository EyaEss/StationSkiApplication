package com.example.station_ski.Service;

import com.example.station_ski.entities.Inscription;

import java.util.List;

public interface IInscriptionSevice {
    public Inscription addInscription(Inscription inscription);
    public void  deleteInscription (Long inscriptionId);
    public Inscription updateInscription( Inscription inscription);
    public Inscription getInscription(Long inscriptionId);
    public List<Inscription> getAllInscription();

    Inscription addInscriptionAndAssignToSkier(Inscription inscription, Long id);
    public void testscheduled(); // la argument le type de retour

}
