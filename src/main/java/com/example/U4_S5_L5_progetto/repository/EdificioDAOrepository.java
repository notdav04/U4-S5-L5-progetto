package com.example.U4_S5_L5_progetto.repository;

import com.example.U4_S5_L5_progetto.model.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdificioDAOrepository extends JpaRepository<Edificio, Long> {
}
