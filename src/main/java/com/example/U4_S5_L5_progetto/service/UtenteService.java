package com.example.U4_S5_L5_progetto.service;

import com.example.U4_S5_L5_progetto.model.Postazione;
import com.example.U4_S5_L5_progetto.model.Utente;
import com.example.U4_S5_L5_progetto.repository.EdificioDAOrepository;
import com.example.U4_S5_L5_progetto.repository.UtenteDAOrepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

    @Autowired
    UtenteDAOrepository utenteDAO;

    @Autowired
    @Qualifier("utente1")
    ObjectProvider<Utente> utente1provider;

    @Autowired
    @Qualifier("utente2")
    ObjectProvider<Utente> utente2provider;

    @Autowired
    @Qualifier("utente3")
    ObjectProvider<Utente> utente3provider;

    public Utente createUtente1(){
        return utente1provider.getObject();
    }

    public Utente createUtente2(){
        return utente2provider.getObject();
    }

    public Utente createUtente3(){
        return utente3provider.getObject();
    }

    public void saveUtente(Utente utente){
        utenteDAO.save(utente);
        System.out.println("utente salvato con successo!");
    }

    public Utente findUtenteById(long id){
        return utenteDAO.findById(id).get();
    }
}
