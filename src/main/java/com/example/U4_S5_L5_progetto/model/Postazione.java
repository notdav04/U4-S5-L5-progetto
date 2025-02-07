package com.example.U4_S5_L5_progetto.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "postazioni")
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo;

    @Column(name = "numero_massimo_occupanti")
    private int nMax;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    private boolean disponibile = true;

    @OneToMany
    @JoinColumn(name = "prenotazione_id")
    private List<Prenotazione> listaprenotazioni= new ArrayList<>();



    public Postazione(String description, TipoPostazione tipo, int nMax, Edificio edificio) {
        this.description = description;
        this.tipo = tipo;
        this.nMax = nMax;
        this.edificio = edificio;
    }
}
