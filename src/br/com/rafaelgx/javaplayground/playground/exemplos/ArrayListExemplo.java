package br.com.rafaelgx.javaplayground.playground.exemplos;


import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Objects;

public class ArrayListExemplo {
    ArrayList<String> nomes = new ArrayList();

    public void adiciona(String nome) {
        this.nomes.add(nome);
    }

    public void remove(String nome) {
        this.nomes.remove(nome);
    }

    public int tamanho() {
        return this.nomes.size();
    }

    public boolean contem(String nome) {
        return this.nomes.contains(nome);
    }

    public String get(int indice) {
        return (String)this.nomes.get(indice);
    }

    public void set(int indice, String nome) {
        this.nomes.set(indice, nome);
    }

    public void limpa() {
        this.nomes.clear();
    }

    public boolean vazio() {
        return this.nomes.isEmpty();
    }

    public boolean naoVazio() {
        return !this.nomes.isEmpty();
    }

    public String[] toArray() {
        return (String[])this.nomes.toArray(new String[this.nomes.size()]);
    }

    public void lista() {
        for(String nome : this.nomes) {
            System.out.println(nome);
        }

        ArrayList var10000 = this.nomes;
        PrintStream var10001 = System.out;
        Objects.requireNonNull(var10001);
        var10000.forEach(var10001::println);
        this.nomes.forEach((nomex) -> System.out.println(nomex));
    }
}
