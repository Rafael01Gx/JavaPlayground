package br.com.rafaelgx.javaplayground.playground.streams;
import java.util.*;
import java.util.stream.Collectors;

public class ExemploStreams {

      void ExemploStreams() {
        // Lista de exemplo
        List<String> frutas = Arrays.asList("Maçã", "Banana", "Laranja", "Abacaxi", "Manga", "Melancia");

        System.out.println("Lista original: " + frutas);

        // ---------------- FILTER ----------------
        // Filtrar frutas que começam com a letra "M"
        List<String> frutasComM = frutas.stream()
                .filter(f -> f.startsWith("M"))
                .collect(Collectors.toList());
        System.out.println("Frutas que começam com M: " + frutasComM);

        // ---------------- MAP ----------------
        // Transformar todos os nomes em maiúsculas
        List<String> frutasMaiusculas = frutas.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Frutas em maiúsculas: " + frutasMaiusculas);

        // ---------------- SORTED ----------------
        // Ordenar alfabeticamente
        List<String> frutasOrdenadas = frutas.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Frutas ordenadas: " + frutasOrdenadas);

        // ---------------- COUNT ----------------
        // Contar quantas frutas têm mais de 5 letras
        long qtdFrutasGrandes = frutas.stream()
                .filter(f -> f.length() > 5)
                .count();
        System.out.println("Quantidade de frutas com mais de 5 letras: " + qtdFrutasGrandes);

        // ---------------- FOREACH ----------------
        // Exibir cada fruta
        System.out.print("Percorrendo frutas com forEach: ");
        frutas.stream().forEach(f -> System.out.print(f + " | "));
    }
}
