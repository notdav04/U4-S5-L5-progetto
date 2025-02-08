package com.example.U4_S5_L5_progetto.repository;

import com.example.U4_S5_L5_progetto.model.Prenotazione;
import com.example.U4_S5_L5_progetto.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneDAOrepository extends JpaRepository<Prenotazione, Long> {

    @Query("SELECT p FROM Prenotazione p JOIN p.utente u WHERE p.dataPrenotazione = :data AND u = :utente")
    public Prenotazione getAllPrenotazioniByDataAndUtente(LocalDate data, Utente utente);


    public List<Prenotazione> findByDataPrenotazioneLessThan(LocalDate now);
}
