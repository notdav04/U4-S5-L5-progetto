package com.example.U4_S5_L5_progetto.configuration;

import com.example.U4_S5_L5_progetto.model.Edificio;
import com.example.U4_S5_L5_progetto.model.Postazione;
import com.example.U4_S5_L5_progetto.model.TipoPostazione;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class PostazioneConfig {


    @Bean("postazione1")
    public Postazione postazione1Bean(Edificio edificio){
        return new Postazione("secondo piano stanza 23", TipoPostazione.OPENSPACE, 50, edificio );
    }
    @Bean("postazione2")
    public Postazione postazione2Bean( @Qualifier("edificio1") Edificio edificio){
        return new Postazione("terzo piano stanza 34", TipoPostazione.SALA_RIUNIONI, 300, edificio );
    }
    @Bean("postazione3")
    public Postazione postazione3Bean( @Qualifier("edificio1") Edificio edificio){
        return new Postazione("quarto piano stanza 48", TipoPostazione.PRIVATO, 25, edificio );
    }
}
