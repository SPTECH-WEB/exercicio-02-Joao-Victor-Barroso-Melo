package com.example.exercicio2.exercicio2.controller;

import com.example.exercicio2.exercicio2.services.FreteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/frete")
public class FreteController {
    private final FreteService freteService;

    public FreteController(FreteService freteService) {
        this.freteService = freteService;
    }

    @GetMapping
    public String calcularFrete(@RequestParam String modalidade, @RequestParam double peso){
        double valor = freteService.calcular(modalidade, peso);
        return "Frete %s para %.2f Kg: %.2f".formatted(modalidade, peso, valor);
    }
}
