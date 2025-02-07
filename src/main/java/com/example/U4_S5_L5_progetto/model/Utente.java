package com.example.U4_S5_L5_progetto.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String fullname;


    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany
    private List<Prenotazione> listaPrenotazioni= new ArrayList<>();

    public Utente(String username, String fullname, String email){
        this.username=username;
        this.fullname=fullname;
        this.email=email;

    }

    public void addPrenotazione(Prenotazione p ){
        List<LocalDate> datePrenotazioni= new ArrayList<>();
        this.listaPrenotazioni.forEach(ele->datePrenotazioni.add(ele.getDataPrenotazione()));
        if (!datePrenotazioni.contains(p.getDataPrenotazione())){
            if (p.getPostazione().isDisponibile()) {
                this.listaPrenotazioni.add(p);
            }else {
                System.out.println("postazione non disponibile, prova per un altro giorno");
            }
        }else {
            System.out.println("hai gia prenotato un altra postazione per quel giorno");
        }
    }

}
