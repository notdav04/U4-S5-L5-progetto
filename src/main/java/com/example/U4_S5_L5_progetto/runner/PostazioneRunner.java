package com.example.U4_S5_L5_progetto.runner;

import com.example.U4_S5_L5_progetto.model.Postazione;
import com.example.U4_S5_L5_progetto.service.EdificioService;
import com.example.U4_S5_L5_progetto.service.PostazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PostazioneRunner implements CommandLineRunner {
    @Autowired private PostazioneService postazioneService;
    @Autowired private EdificioService edificioService;
    @Override
    public void run(String... args) throws Exception {

        Postazione p1 = postazioneService.createPostazione1(edificioService.findEdificioById(1));
//        Postazione p2 = postazioneService.createPostazione2();
//        Postazione p3 = postazioneService.createPostazione3();

        postazioneService.savePostazione(p1);
//        postazioneService.savePostazione(p2);
//        postazioneService.savePostazione(p3);

    }
}
