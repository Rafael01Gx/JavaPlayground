package br.com.rafaelgx.javaplayground.playground.exemplos;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Objects;

public class OrdenarDados {
    public static void main(String[] args) {
        ArrayList<String> nomes = new ArrayList();
        nomes.add("Rafael");
        nomes.add("Julia");
        nomes.add("Pedro");
        nomes.add("Ana");
        nomes.add("Beatriz");
        nomes.add("Carlos");
        nomes.sort(String::compareToIgnoreCase);
        PrintStream var10001 = System.out;
        Objects.requireNonNull(var10001);
        nomes.forEach(var10001::println);
    }
}
