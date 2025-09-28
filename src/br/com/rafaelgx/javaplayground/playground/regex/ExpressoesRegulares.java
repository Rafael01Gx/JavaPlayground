package br.com.rafaelgx.javaplayground.playground.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressoesRegulares {

    private final String textoOriginal;

    /**
     * Construtor que armazena o texto a ser analisado.
     * @param texto O texto de entrada para todos os exemplos.
     */
    public ExpressoesRegulares(String texto) {
        this.textoOriginal = texto;
        IO.println("=================================================");
        IO.println("TEXTO ANALISADO: \"" + this.textoOriginal + "\"");
        IO.println("=================================================");
    }

    // Método principal para demonstrações
    public static void main(String[] args) {
        String texto = "Meu e-mail é teste@java.com.br e meu telefone é (11) 98765-4321. "
                + "A data de hoje é 25/09/2025. Existe um segundo e-mail: outro_exemplo@email.co.";

        ExpressoesRegulares demo = new ExpressoesRegulares(texto);

        demo.demonstrarBuscaSimples();
        demo.demonstrarQuantificadores();
        demo.demonstrarConjuntosDeCaracteres();
        demo.demonstrarValidacaoDeEmail();
    }

    // ------------------------------------------------------------------------------------------------

    /**
     * 1. Demonstra a busca simples usando um padrão literal e metacaracteres básicos.
     * Padrões: . (qualquer caractere), \s (espaço), \w (letra/número/underline).
     */
    public void demonstrarBuscaSimples() {
        IO.println("\n--- 1. BUSCA SIMPLES E METACARACTERES ---");

        // Padrão: 4 letras, um ponto, e mais 3 letras.
        // O ponto ( . ) precisa ser escapado (\.) para significar um ponto LITERAL.
        String regex = "\\w\\w\\w\\w\\.\\w\\w\\w"; // Ex: java.com

        // Explicação: \w = Qualquer caractere de palavra (a-z, A-Z, 0-9, _)

        executarBusca(regex, "Encontrando a sequência 'java.com' ou similar...");
    }

    // ------------------------------------------------------------------------------------------------

    /**
     * 2. Demonstra o uso de Quantificadores (dizem "quantas vezes" um padrão repete).
     * Quantificadores: + (1 ou mais), * (0 ou mais), ? (0 ou 1), {n} (exatamente n).
     */
    public void demonstrarQuantificadores() {
        IO.println("\n--- 2. QUANTIFICADORES ---");

        // Padrão para DATA: dois dígitos, barra, dois dígitos, barra, quatro dígitos.
        // Explicação: \d = Qualquer dígito (0-9)
        String regexData = "\\d{2}/\\d{2}/\\d{4}";
        executarBusca(regexData, "Busca por uma Data (DD/MM/AAAA) usando \\d{n}...");

        // Padrão para Palavras: \w+
        // Explicação: \w+ = uma ou mais (\+) repetições de caracteres de palavra (\w).
        String regexPalavra = "\\w+";
        executarBusca(regexPalavra, "Busca por todas as Palavras (\\w+) no texto...");
    }

    // ------------------------------------------------------------------------------------------------

    /**
     * 3. Demonstra Conjuntos de Caracteres e Agrupamento.
     * Conjuntos: [abc] (a ou b ou c), ( ) (agrupamento).
     */
    public void demonstrarConjuntosDeCaracteres() {
        IO.println("\n--- 3. CONJUNTOS E AGRUPAMENTO ---");

        // Padrão para NÚMEROS TELEFONE (simplificado):
        // Explicação: \(\d{2}\) agrupa o código de área. \d+ agrupa o restante.
        // Os parênteses literais precisam ser escapados: \( e \)
        String regexTelefone = "\\(\\d{2}\\) \\d+-\\d+";
        executarBusca(regexTelefone, "Busca por Telefone ((XX) XXXX-XXXX) usando Agrupamento...");

        // Padrão: [aeiou] busca por qualquer vogal minúscula.
        String regexVogais = "[aeiou]";
        executarBusca(regexVogais, "Busca por todas as Vogais minúsculas ([aeiou])...");
    }

    // ------------------------------------------------------------------------------------------------

    /**
     * 4. Demonstra a aplicação mais complexa: Validação de E-mail.
     */
    public void demonstrarValidacaoDeEmail() {
        IO.println("\n--- 4. APLICAÇÃO: VALIDAÇÃO DE E-MAIL ---");

        // Padrão de email BÁSICO:
        // \w+  -> 1 ou mais caracteres de palavra (nome de usuário)
        // @    -> Símbolo literal @
        // \w+  -> 1 ou mais caracteres de palavra (domínio)
        // \.   -> Ponto literal
        // \w+  -> 1 ou mais caracteres de palavra (extensão .com, .br, etc.)
        String regexEmail = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
        // O (\\.\\w+)? no final torna extensões como .com.br opcionais.

        executarBusca(regexEmail, "Busca por E-mails no texto...");
    }

    // ------------------------------------------------------------------------------------------------

    /**
     * Método utilitário que compila a regex e executa a busca no texto.
     */
    private void executarBusca(String regex, String descricao) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(this.textoOriginal);

        IO.println("\nDescrição: " + descricao);
        IO.print("REGEX: /" + regex + "/ -> ");

        boolean encontrado = false;

        while (matcher.find()) {
            IO.print("[" + matcher.group() + "] ");
            encontrado = true;
        }

        if (!encontrado) {
            IO.print("NENHUM resultado encontrado.");
        }
        IO.println("\n-------------------------------------------");
    }
}