package com.example.U4_S5_L5_progetto.runner;

import com.example.U4_S5_L5_progetto.model.Edificio;
import com.example.U4_S5_L5_progetto.service.EdificioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EdificioRunner implements CommandLineRunner {

    @Autowired private EdificioService edificioService;

    @Override
    public void run(String... args) throws Exception {
        Edificio e1 = edificioService.createEdificio1();
        edificioService.saveEdificio(e1);
    }
}
