package com.example.U4_S5_L5_progetto.service;

import com.example.U4_S5_L5_progetto.model.Postazione;
import com.example.U4_S5_L5_progetto.model.Prenotazione;
import com.example.U4_S5_L5_progetto.model.Utente;
import com.example.U4_S5_L5_progetto.repository.EdificioDAOrepository;
import com.example.U4_S5_L5_progetto.repository.PostazioneDAOrepository;
import com.example.U4_S5_L5_progetto.repository.PrenotazioneDAOrepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrenotazioneService {

    @Autowired
    PrenotazioneDAOrepository prenotazioneDAO;
    @Autowired
    PostazioneDAOrepository postazioneDAO;


    @Autowired
    @Qualifier("prenotazioneCustom")
    ObjectProvider<Prenotazione> prenotazioneProvider;

    //metodo per creare la prenotazione dopo aver verificato la disponibilita della postazione e che l utente non abbia una prenotazione attiva per lo stesso giorno
    public Prenotazione createPrenotazione(Postazione postazione, LocalDate dataPrenotazione, Utente utente) {
        Postazione postazioneDisponibile = postazioneDAO.getPostazioneDisponibile(postazione.getDescription(), dataPrenotazione);
        Prenotazione prenotazioneUtente = prenotazioneDAO.getAllPrenotazioniByDataAndUtente(dataPrenotazione, utente);

        if (postazioneDisponibile != null && prenotazioneUtente == null) { // La postazione è disponibile
            Prenotazione p = prenotazioneProvider.getObject();
            p.setPostazione(postazioneDisponibile);
            p.setDataPrenotazione(dataPrenotazione);
            p.setUtente(utente);

            return p;
        } else {
            System.out.println("La postazione selezionata non è disponibile per la data richiesta o  l utente ha gia una prenotazione attiva per la data impostata");
            return null;
        }
    }

    public void savePrenotazione(Prenotazione prenotazione) {
        if (prenotazione !=null){

            prenotazioneDAO.save(prenotazione);

            System.out.println("prenotazione salvata con successo!");
        }
    }

    public void deletePrenotazione(Prenotazione p){
        prenotazioneDAO.deleteById(p.getId());
        System.out.println("prenotazione eliminata con successo!");
    }

    public void autoDeleteOldPrenotazioni(){
        List<Prenotazione> listaPrenotazioni = prenotazioneDAO.findByDataPrenotazioneLessThan(LocalDate.now());
        listaPrenotazioni.forEach(ele->prenotazioneDAO.deleteById(ele.getId()));
        System.out.println("prenotazioni scadute eliminate");


    }
}
