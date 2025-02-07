package com.example.U4_S5_L5_progetto.service;

import com.example.U4_S5_L5_progetto.model.Utente;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {
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
}
