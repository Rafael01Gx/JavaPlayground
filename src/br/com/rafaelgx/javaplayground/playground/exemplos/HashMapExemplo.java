package br.com.rafaelgx.javaplayground.playground.exemplos;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class HashMapExemplo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap();
        map.put("Rafael", 20);
        map.put("Julia", 18);
        map.put("Pedro", 19);
        map.put("Ana", 17);
        map.put("Beatriz", 16);
        int valor = (Integer)map.get("Rafael");
        System.out.println("Valor da chave 'Rafael': " + valor);
        map.remove("Rafael");
        System.out.println("Valor da chave 'Rafael': " + String.valueOf(map.get("Rafael")));

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            PrintStream var10000 = System.out;
            String var10001 = (String)entry.getKey();
            var10000.println("Chave: " + var10001 + ", Valor: " + String.valueOf(entry.getValue()));
        }

        for(String chave : map.keySet()) {
            System.out.println("Chave: " + chave + ", Valor: " + String.valueOf(map.get(chave)));
        }

    }
}
