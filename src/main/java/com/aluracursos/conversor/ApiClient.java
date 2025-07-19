package com.aluracursos.conversor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ApiClient {
    private static final String API_KEY = "b0f283288e9a985e9ac6406d";
    private static final String API_BASE_URL = "https://v6.exchangerate-api.com/v6/";

    private final HttpClient httpClient;

    public ApiClient() {
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
    }

    public String getExchangeRates(String baseCurrency) throws Exception {
        String url = API_BASE_URL + API_KEY + "/latest/" + baseCurrency;

        System.out.println("Solicitando tasas para: " + url);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();
        } else {
            String errorMessage = "Error en la solicitud HTTP. Código de estado: " + response.statusCode() +
                    "\nCuerpo de respuesta: " + response.body();
            System.err.println(errorMessage);
            throw new RuntimeException(errorMessage);
        }
    }
}

