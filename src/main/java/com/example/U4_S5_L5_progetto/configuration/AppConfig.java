package com.example.U4_S5_L5_progetto.configuration;

import com.example.U4_S5_L5_progetto.model.*;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Locale;

@Configuration
public class AppConfig {

    Faker fake = Faker.instance(new Locale("it-IT"));


    @Bean("utente1")
    @Scope("singleton")
    public Utente utente1Bean(){
        return new Utente("pluto21", fake.name().fullName(), fake.internet().emailAddress());
    }
    @Bean("utente2")
    @Scope("singleton")
    public Utente utente2Bean(){
        return new Utente("pippo14", fake.name().fullName(), fake.internet().emailAddress());
    }
    @Bean("utente3")
    @Scope("singleton")
    public Utente utente3Bean(){
        return new Utente("paperino11", fake.name().fullName(), fake.internet().emailAddress());
    }

    @Bean("edificiocustom")
    @Scope("singleton")
    public Edificio edificio1Bean(){
        Faker fake = Faker.instance(new Locale("it-IT"));
        return new Edificio("central building", fake.address().streetAddress(), fake.address().cityName() );
    }

    @Bean("postazione1")
    public Postazione postazione1Bean( @Qualifier("edificio1") Edificio edificio){
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

    @Bean("prenotazioneCustom")
    @Scope("prototype")
    public Prenotazione prenotazioneBean(){
        return new Prenotazione();
    }


}
