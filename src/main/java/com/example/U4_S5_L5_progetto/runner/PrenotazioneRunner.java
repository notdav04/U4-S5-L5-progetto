package com.example.U4_S5_L5_progetto.runner;

import com.example.U4_S5_L5_progetto.model.Prenotazione;
import com.example.U4_S5_L5_progetto.service.PostazioneService;
import com.example.U4_S5_L5_progetto.service.PrenotazioneService;
import com.example.U4_S5_L5_progetto.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PrenotazioneRunner implements CommandLineRunner {

    @Autowired
    private PrenotazioneService prenotazioneService;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private PostazioneService postazioneService;

    @Override
    public void run(String... args) throws Exception {
        prenotazioneService.autoDeleteOldPrenotazioni();
//        Prenotazione p1 = prenotazioneService.createPrenotazione(LocalDate.now(), utenteService.findUtenteById(1), postazioneService.findPostazioneById(1));
//        prenotazioneService.savePrenotazione(p1);
//        Prenotazione p2 = prenotazioneService.createPrenotazione(postazioneService.findPostazioneById(2), LocalDate.of(2025, 2, 10), utenteService.findUtenteById(2));
//
//            prenotazioneService.savePrenotazione(p2);





    }
}
