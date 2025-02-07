package com.example.U4_S5_L5_progetto.configuration;

import com.example.U4_S5_L5_progetto.model.Edificio;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Locale;

@Configuration
public class EdificioConfig {




    @Bean("edificio1")
    @Scope("singleton")
    public Edificio edificio1Bean(){
        Faker fake = Faker.instance(new Locale("it-IT"));
        return new Edificio("central building", fake.address().streetAddress(), fake.address().cityName() );
    }
}
