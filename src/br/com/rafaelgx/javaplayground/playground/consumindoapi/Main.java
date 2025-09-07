package br.com.rafaelgx.javaplayground.playground.consumindoapi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

public class Main {
    static final String OMDB_URL = "http://www.omdbapi.com";
    static final String API_KEY = "1d4cac1";

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Digite o nome do filme: ");
        String filme = (new Scanner(System.in)).next();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://www.omdbapi.com/?t=" + filme.replace(" ", "").toLowerCase() + "&apikey=1d4cac1")).build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        System.out.println((String)response.body());
    }
}
