package com.example.U4_S5_L5_progetto.repository;

import com.example.U4_S5_L5_progetto.model.Postazione;
import com.example.U4_S5_L5_progetto.model.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostazioneDAOrepository extends JpaRepository<Postazione, Long> {


    @Query("SELECT p FROM Postazione p WHERE p.disponibile = true AND p.description = :descrizione AND NOT EXISTS (" +
            "SELECT pr FROM Prenotazione pr WHERE pr.postazione = p AND pr.dataPrenotazione = :dataPrenotazione)")
    public Postazione getPostazioneDisponibile(String descrizione, LocalDate dataPrenotazione);

    @Query("SELECT p FROM Postazione p JOIN FETCH p.edificio e WHERE p.tipo = :tipo AND e.citta = :citta")
    public List<Postazione> searchByTypeAndCity(TipoPostazione tipo, String citta);
}
