package com.example.U4_S5_L5_progetto.runner;

import com.example.U4_S5_L5_progetto.model.Utente;
import com.example.U4_S5_L5_progetto.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UtenteRunner implements CommandLineRunner {

    @Autowired private UtenteService utenteService;
    @Override
    public void run(String... args) throws Exception {

//        Utente u1 = utenteService.createUtente1();
//        Utente u2 = utenteService.createUtente2();
//        Utente u3 = utenteService.createUtente3();
//        utenteService.saveUtente(u1);
//        utenteService.saveUtente(u2);
//        utenteService.saveUtente(u3);

    }
}
