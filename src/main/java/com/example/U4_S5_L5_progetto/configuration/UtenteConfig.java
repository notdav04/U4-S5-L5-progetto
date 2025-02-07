package com.example.U4_S5_L5_progetto.configuration;

import com.example.U4_S5_L5_progetto.model.Utente;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Locale;

@Configuration
public class UtenteConfig {
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
}
