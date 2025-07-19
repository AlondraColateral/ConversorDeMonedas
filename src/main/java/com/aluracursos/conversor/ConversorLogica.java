package com.aluracursos.conversor;

import java.util.Map;

public class ConversorLogica {

    private final Map<String, Double> rates;

    public ConversorLogica(Map<String, Double> rates) {
        if (rates == null || rates.isEmpty()) {
            throw new IllegalArgumentException("Las tasas de conversión no pueden ser nulas o vacías.");
        }
        this.rates = rates;
    }

    public double convertir(double cantidad, String monedaOrigen, String monedaDestino) {
        Double tasaOrigen = rates.get(monedaOrigen);
        Double tasaDestino = rates.get(monedaDestino);

        if (tasaOrigen == null || tasaDestino == null) {
            throw new IllegalArgumentException("Una de las monedas seleccionadas no tiene una tasa de conversión válida.");
        }

        double valorEnBase = cantidad / tasaOrigen;

        double resultado = valorEnBase * tasaDestino;
        return resultado;
    }
}
