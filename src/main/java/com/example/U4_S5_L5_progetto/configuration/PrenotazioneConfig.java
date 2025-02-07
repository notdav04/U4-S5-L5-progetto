package com.example.U4_S5_L5_progetto.configuration;

import com.example.U4_S5_L5_progetto.model.Prenotazione;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Locale;

@Configuration
public class PrenotazioneConfig {


    @Bean("prenotazioneCustom")
    @Scope("prototype")
    public Prenotazione prenotazioneBean(){
        return new Prenotazione();
    }
}
