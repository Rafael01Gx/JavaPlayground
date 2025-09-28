package br.com.rafaelgx.javaplayground.alura.principal;

import br.com.rafaelgx.javaplayground.alura.modelos.Filme;
import br.com.rafaelgx.javaplayground.alura.modelos.Serie;
import br.com.rafaelgx.javaplayground.alura.modelos.Titulo;
import br.com.rafaelgx.javaplayground.alura.modelos.TituloOmdb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme(null);
        meuFilme.avalia(9);
        Filme outroFilme = new Filme(null);
        outroFilme.avalia(6);
        var filmeDoPaulo = new Filme(null);
        filmeDoPaulo.avalia(10);
        TituloOmdb tituloOmdb = new TituloOmdb("Lost", "2000","300 min");
        Serie lost = new Serie(tituloOmdb);

        Filme f1 = filmeDoPaulo;

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filmeDoPaulo);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);
        for (Titulo item: lista) {
            System.out.println(item.getNome());
            if (item instanceof  Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação " + filme.getClassificacao());
            }
        }

        List<String> buscaPorArtista = new LinkedList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jacqueline");
        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println("Depois da ordenação");
        System.out.println(buscaPorArtista);
        System.out.println("Lista de titulos ordenados");
        Collections.sort(lista);
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenando por ano");
        System.out.println(lista);
    }
}
