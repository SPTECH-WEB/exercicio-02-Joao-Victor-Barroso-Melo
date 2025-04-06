package com.example.exercicio2.exercicio2.services;

import org.springframework.stereotype.Service;

@Service("correiosFrete")
public class FreteAdapter implements FreteAdapterInterface {
    private final FreteCorreios freteCorreios;

    public FreteAdapter(FreteCorreios freteCorreios) {
        this.freteCorreios = freteCorreios;
    }

    @Override
    public void freteExterno(double peso) {
        double valor = freteCorreios.calcularFrete(peso);
        System.out.println("Frete correios R$ %.2f".formatted(valor));
    }
}
