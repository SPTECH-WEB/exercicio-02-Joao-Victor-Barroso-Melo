package com.example.exercicio2.exercicio2.controller;

import com.example.exercicio2.exercicio2.services.adapter.FreteAdapterInterface;
import com.example.exercicio2.exercicio2.services.strategy.FreteService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/frete")
public class FreteController {
    private final FreteService freteService;
    private final FreteAdapterInterface freteAdapter;

    public FreteController(FreteService freteService,
                           @Qualifier("correiosFrete") FreteAdapterInterface freteAdapter) {
        this.freteService = freteService;
        this.freteAdapter = freteAdapter;
    }

    @GetMapping
    public String calcularFrete(@RequestParam String modalidade, @RequestParam double peso){
        double valor = freteService.calcular(modalidade, peso);
        return "Frete %s para %.2f Kg: %.2f".formatted(modalidade, peso, valor);
    }

    @PostMapping
    public String calcFreteExterno(@RequestParam double peso){
        freteAdapter.freteExterno(peso);
        return "Frete calulado correios";
    }
}
