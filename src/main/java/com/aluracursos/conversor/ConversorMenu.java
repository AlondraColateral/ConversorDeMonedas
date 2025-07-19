package com.aluracursos.conversor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConversorMenu {

    private ApiClient client;
    private Gson gson;
    private Scanner lectura;
    private ConversorLogica conversorLogica;
    private List<String> historialConsultas;

    public ConversorMenu() throws Exception {
        this.client = new ApiClient();
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.lectura = new Scanner(System.in);
        this.historialConsultas = new ArrayList<>();

        String baseCurrencyForApi = "USD";
        String jsonResponse = client.getExchangeRates(baseCurrencyForApi);
        Map<String, Double> rates = gson.fromJson(jsonResponse, ApiResponse.class).getConversion_rates();

        this.conversorLogica = new ConversorLogica(rates);
    }

    public void iniciar() {
        String opcionStr = "";
        int opcionNumerica = 0;

        String monedaOrigen = "";
        String monedaDestino = "";
        double cantidad = 0.0;

        while (!opcionStr.equalsIgnoreCase("s")) {
            mostrarMenu();

            opcionStr = lectura.nextLine().trim();

            if (opcionStr.equalsIgnoreCase("s")) {
                System.out.println("\nSaliendo del conversor. ¡Hasta pronto!\n");
                break;
            }

            try {
                opcionNumerica = Integer.parseInt(opcionStr);

                if (opcionNumerica == 9) {
                    mostrarHistorial();
                    continue;
                }

                if (opcionNumerica < 1 || opcionNumerica > 8) { // Rango para opciones de conversión
                    mostrarError("Opción inválida. Por favor, ingrese un número del 1 al 9 o 's' para salir.");
                    continue;
                }

            } catch (NumberFormatException e) {
                mostrarError("Opción no válida. Por favor, ingrese un número del 1 al 9 o 's' para salir.");
                continue;
            }

            monedaOrigen = getMonedaOrigen(opcionNumerica);
            monedaDestino = getMonedaDestino(opcionNumerica);

            if (monedaOrigen.isEmpty() || monedaDestino.isEmpty()) {
                mostrarError("No se pudo identificar la conversión para la opción seleccionada. Intente de nuevo.");
                continue;
            }

            try {
                System.out.printf("Por favor, ingrese la cantidad de %s a convertir: ", monedaOrigen);
                cantidad = lectura.nextDouble();
            } catch (InputMismatchException e) {
                mostrarError("Cantidad no válida. Por favor, ingrese un número.");
                lectura.next();
                continue;
            }
            lectura.nextLine();

            try {
                double resultado = conversorLogica.convertir(cantidad, monedaOrigen, monedaDestino);
                String resultadoFormateado = String.format("El valor de %.2f %s equivale a %.2f %s", cantidad, monedaOrigen, resultado, monedaDestino);

                historialConsultas.add(resultadoFormateado);

                System.out.println("\n--- ¡CONVERSIÓN REALIZADA! ---");
                System.out.println(resultadoFormateado);
                System.out.println("--------------------------------\n");

            } catch (IllegalArgumentException e) {
                mostrarError("Error en la conversión: " + e.getMessage() + "\nPor favor, revise la moneda o la cantidad e intente de nuevo.");
            }
        }

        lectura.close();
    }

    private void mostrarMenu() {
        System.out.println("\n\n**************************************************");
        System.out.println("¡Hola! Bienvenido/a al Conversor de Moneda =]");
        System.out.println("1) Peso Chileno >> Dólar");
        System.out.println("2) Dólar >> Peso Chileno");
        System.out.println("3) Peso Argentino >> Dólar");
        System.out.println("4) Dólar >> Peso Argentino");
        System.out.println("5) Real Brasileño >> Dólar");
        System.out.println("6) Dólar >> Real Brasileño");
        System.out.println("7) Peso Colombiano >> Dólar");
        System.out.println("8) Dólar >> Peso Colombiano");
        System.out.println("9) Mostrar Historial de Conversiones");
        System.out.println("S) Salir");
        System.out.println("Por favor, ingrese un número del 1 al 9 o 's' para elegir una opción:");
        System.out.println("**************************************************\n");
    }

    private String getMonedaOrigen(int opcion) {
        switch (opcion) {
            case 1: return "CLP";
            case 2: return "USD";
            case 3: return "ARS";
            case 4: return "USD";
            case 5: return "BRL";
            case 6: return "USD";
            case 7: return "COP";
            case 8: return "USD";
            default: return "";
        }
    }

    private String getMonedaDestino(int opcion) {
        switch (opcion) {
            case 1: return "USD";
            case 2: return "CLP";
            case 3: return "USD";
            case 4: return "ARS";
            case 5: return "USD";
            case 6: return "BRL";
            case 7: return "USD";
            case 8: return "COP";
            default: return "";
        }
    }

    private void mostrarHistorial() {
        System.out.println("\n--- HISTORIAL DE CONVERSIONES ---");
        if (historialConsultas.isEmpty()) {
            System.out.println("Aún no se han realizado conversiones.");
        } else {
            for (int i = 0; i < historialConsultas.size(); i++) {
                System.out.println((i + 1) + ". " + historialConsultas.get(i));
            }
        }
        System.out.println("-----------------------------------\n");
    }

   private void mostrarError(String mensaje) {
        System.out.println("\n--- ¡ERROR! ---");
        System.out.println(mensaje);
        System.out.println("----------------\n");
    }
}