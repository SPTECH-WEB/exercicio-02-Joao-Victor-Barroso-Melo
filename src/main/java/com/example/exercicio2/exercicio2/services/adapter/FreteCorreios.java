package com.example.exercicio2.exercicio2.services.adapter;

import org.springframework.stereotype.Component;

@Component
public class FreteCorreios {
    public double calcularFrete(double peso){
       return peso * 20;
    }
}
