package com.example.exercicio2.exercicio2.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreteService {
    private final List<FreteStrategy> estrategias;

    public FreteService(List<FreteStrategy> estrategias) {
        this.estrategias = estrategias;
    }

    public double calcular(String tipo, double peso){
        return estrategias.stream()
                .filter(e -> e.modalidade().equalsIgnoreCase(tipo))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Tipo de argumento invalido"))
                .calcular(peso);
    }
}
