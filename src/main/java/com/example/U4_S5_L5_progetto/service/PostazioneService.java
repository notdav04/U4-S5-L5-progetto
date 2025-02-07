package com.example.U4_S5_L5_progetto.service;

import com.example.U4_S5_L5_progetto.model.Postazione;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PostazioneService {
    @Autowired
    @Qualifier("postazione1")
    ObjectProvider<Postazione> postazione1provider;

    @Autowired
    @Qualifier("postazione2")
    ObjectProvider<Postazione> postazione2provider;

    @Autowired
    @Qualifier("postazione3")
    ObjectProvider<Postazione> postazione3provider;

    public Postazione createPostazione1(){
        return postazione1provider.getObject();
    }

    public Postazione createPostazione2(){
        return postazione2provider.getObject();
    }

    public Postazione createPostazione3(){
        return postazione3provider.getObject();
    }
}
