package com.example.U4_S5_L5_progetto.service;

import com.example.U4_S5_L5_progetto.model.Edificio;
import com.example.U4_S5_L5_progetto.model.Postazione;
import com.example.U4_S5_L5_progetto.model.TipoPostazione;
import com.example.U4_S5_L5_progetto.repository.EdificioDAOrepository;
import com.example.U4_S5_L5_progetto.repository.PostazioneDAOrepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostazioneService {
    @Autowired
    PostazioneDAOrepository postazioneDAO;

    @Autowired
    @Qualifier("postazione1")
    ObjectProvider<Postazione> postazione1provider;

    @Autowired
    @Qualifier("postazione2")
    ObjectProvider<Postazione> postazione2provider;

    @Autowired
    @Qualifier("postazione3")
    ObjectProvider<Postazione> postazione3provider;

    public Postazione createPostazione1(Edificio edificio){
        Postazione p = postazione1provider.getObject();
        p.setEdificio(edificio);
        return p;
    }

    public Postazione createPostazione2(Edificio edificio){
        Postazione p = postazione2provider.getObject();
        p.setEdificio(edificio);
        return p;
    }

    public Postazione createPostazione3(Edificio edificio){
        Postazione p = postazione3provider.getObject();
        p.setEdificio(edificio);
        return p;
    }

    public void savePostazione(Postazione postazione){
        postazioneDAO.save(postazione);
        System.out.println("postazione salvata con successo!");
    }

    public Postazione findPostazioneById(long id){
        return postazioneDAO.findById(id).get();
    }

    //per eventualmente switchare la disponibilita di una postazione
    public void updateDisponibilita(Postazione p){
        p.setDisponibile(!p.isDisponibile());
        postazioneDAO.save(p);
        System.out.println("disponibilita postazione aggiornata");
    }

    //metodo per ricerca postazione per tipo e citta di interesse
    //transaction trovato online per la risoluzione di errore nella query
    @Transactional(readOnly = true)
    public void searchByTypeAndCity(TipoPostazione tipo, String citta){
        List<Postazione> lista1 = postazioneDAO.searchByTypeAndCity(tipo, citta);
        System.out.println("risultato ricerca postazioni per tipo e citta");
        if (!lista1.isEmpty()) {

            lista1.forEach(ele -> System.out.println(ele));
        }else{
            System.out.println("nessun elemento trovato!");
        }


    }

}
