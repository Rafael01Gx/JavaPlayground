package br.com.rafaelgx.javaplayground.playground.colecoes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ExemploColecoes {

    void ExemploColecoes() {
        // ---------------- ARRAYLIST ----------------
        // Vantagem: rápido para acessar elementos (get), pois usa índice interno
        // Desvantagem: operações de inserção/remoção no meio da lista são mais lentas
        List<String> arrayList = new ArrayList<>();

        // Adicionando elementos
        arrayList.add("Maçã");
        arrayList.add("Banana");
        arrayList.add("Laranja");

        System.out.println("ArrayList inicial: " + arrayList);

        // Pegando elemento pelo índice
        System.out.println("Elemento no índice 1: " + arrayList.get(1));

        // Verificando se contém um elemento
        System.out.println("Contém 'Banana'? " + arrayList.contains("Banana"));

        // Removendo elemento pelo valor
        arrayList.remove("Maçã");
        System.out.println("Após remover 'Maçã': " + arrayList);

        // Tamanho da lista
        System.out.println("Tamanho do ArrayList: " + arrayList.size());


        // ---------------- LINKEDLIST ----------------
        // Vantagem: rápido para inserir/remover em qualquer posição
        // Desvantagem: acesso por índice (get) é mais lento
        List<String> linkedList = new LinkedList<>();

        // Adicionando elementos
        linkedList.add("Cachorro");
        linkedList.add("Gato");
        linkedList.add("Papagaio");

        System.out.println("\nLinkedList inicial: " + linkedList);

        // Pegando elemento pelo índice
        System.out.println("Elemento no índice 2: " + linkedList.get(2));

        // Verificando se contém um elemento
        System.out.println("Contém 'Cachorro'? " + linkedList.contains("Cachorro"));

        // Removendo elemento pelo índice
        linkedList.remove(1); // remove "Gato"
        System.out.println("Após remover índice 1: " + linkedList);

        // Tamanho da lista
        System.out.println("Tamanho do LinkedList: " + linkedList.size());
    }
}

