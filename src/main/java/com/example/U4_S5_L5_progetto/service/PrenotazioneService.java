package com.example.U4_S5_L5_progetto.service;

import com.example.U4_S5_L5_progetto.model.Postazione;
import com.example.U4_S5_L5_progetto.model.Prenotazione;
import com.example.U4_S5_L5_progetto.model.Utente;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PrenotazioneService {

    @Autowired
    @Qualifier("prenotazioneCustom")
    ObjectProvider<Prenotazione> prenotazioneProvider;

    public Prenotazione createPrenotazione(LocalDate data, Utente utente, Postazione postazione){
        Prenotazione p = prenotazioneProvider.getObject();
        p.setDataPrenotazione(data);
        p.setPostazione(postazione);
        p.setUtente(utente);
        return p;
    }
}
