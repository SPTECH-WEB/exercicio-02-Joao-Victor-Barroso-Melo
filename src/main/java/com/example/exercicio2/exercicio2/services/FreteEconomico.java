package com.example.exercicio2.exercicio2.services;

import org.springframework.stereotype.Component;

@Component
public class FreteEconomico implements FreteStrategy {
    @Override
    public double calcular(double peso) {
        return peso * 2.0;
    }

    @Override
    public String modalidade() {
        return "Economico";
    }
}
