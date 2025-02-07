package com.example.U4_S5_L5_progetto.service;

import com.example.U4_S5_L5_progetto.model.Edificio;
import com.example.U4_S5_L5_progetto.repository.EdificioDAOrepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EdificioService {
    @Autowired  EdificioDAOrepository edificioDAO;

    @Autowired
    @Qualifier("edificio1")
    ObjectProvider<Edificio> edificio1provider;

    public Edificio createEdificio1(){
        return edificio1provider.getObject();
    }

    public void saveEdificio(Edificio edificio){
        edificioDAO.save(edificio);
    }
}
