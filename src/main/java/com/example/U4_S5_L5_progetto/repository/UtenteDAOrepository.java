package com.example.U4_S5_L5_progetto.repository;

import com.example.U4_S5_L5_progetto.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteDAOrepository extends JpaRepository<Utente, Long> {

}
