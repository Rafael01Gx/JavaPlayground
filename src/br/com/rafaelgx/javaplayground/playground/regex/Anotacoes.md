# 📘 Tabela Completa de Metacaracteres – Expressões Regulares em Java

## 🔤 1. Padrões de Caracteres

| Símbolo       | Significado                                   | Exemplo      | Casa...                                 |
|---------------|-----------------------------------------------|--------------|------------------------------------------|
| `.`           | Qualquer caractere (exceto nova linha)        | `a.b`        | "acb", "a-b", "a9b", mas não "ab"        |
| `[...]`       | Qualquer caractere dentro dos colchetes       | `[aeiou]`    | Uma vogal                                |
| `[^...]`      | Qualquer caractere exceto os listados         | `[^0-9]`     | Qualquer coisa que não seja número       |
| `[a-z]`       | Intervalo de letras minúsculas                | `[a-z]`      | Letras de "a" até "z"                    |
| `[A-Z]`       | Intervalo de letras maiúsculas                | `[A-Z]`      | Letras de "A" até "Z"                    |
| `[0-9]`       | Dígitos de 0 a 9                              | `[0-9]+`     | Um ou mais números                       |
| `\d`          | Dígito (`[0-9]`)                              | `\d{3}`      | Três dígitos, como "123"                 |
| `\D`          | Não dígito (`[^0-9]`)                         | `\D+`        | Letras, símbolos, etc.                   |
| `\w`          | Palavra: letra, número ou "_"                 | `\w+`        | "abc", "a1_b2"                           |
| `\W`          | Não palavra                                   | `\W+`        | "@!", " ", "#"                           |
| `\s`          | Espaço em branco                              | `\s+`        | " ", "\n", "\t"                          |
| `\S`          | Não espaço em branco                          | `\S+`        | "abc", "123", etc.                       |

---

## 🔢 2. Quantificadores

| Símbolo     | Significado                                       | Exemplo      | Casa...                                  |
|-------------|---------------------------------------------------|--------------|-------------------------------------------|
| `*`         | Zero ou mais vezes                                | `a*`         | "", "a", "aa", "aaa"                      |
| `+`         | Uma ou mais vezes                                 | `a+`         | "a", "aa", "aaa" (mas não "")             |
| `?`         | Zero ou uma vez                                   | `a?`         | "", "a"                                   |
| `{n}`       | Exatamente n vezes                                | `a{3}`       | "aaa"                                     |
| `{n,}`      | Pelo menos n vezes                                | `a{2,}`      | "aa", "aaa", ...                          |
| `{n,m}`     | Entre n e m vezes                                 | `a{2,4}`     | "aa", "aaa", "aaaa"                       |
| `*?`, `+?`  | Quantificador não ganancioso (lazy)               | `a+?`        | "a", ao invés de "aaa" (no caso de "aaa") |

---

## 📍 3. Ancoragem e Fronteiras

| Símbolo     | Significado                                       | Exemplo      | Casa...                                  |
|-------------|---------------------------------------------------|--------------|-------------------------------------------|
| `^`         | Início da string (ou linha, com flag `(?m)`)      | `^abc`       | "abc" no início                          |
| `$`         | Fim da string (ou linha, com flag `(?m)`)         | `xyz$`       | "xyz" no fim                             |
| `\b`        | Fronteira de palavra                              | `\bword\b`   | A palavra "word" isolada                 |
| `\B`        | Não fronteira de palavra                          | `\Bword\B`   | "password", "keyword", mas não "word"    |

---

## 🔁 4. Agrupamento e Alternância

| Símbolo     | Significado                                       | Exemplo           | Casa...                                        |
|-------------|---------------------------------------------------|-------------------|------------------------------------------------|
| `(...)`     | Agrupamento                                       | `(ab)+`           | "ab", "abab", "ababab"                         |
| `(?:...)`   | Agrupamento sem captura                           | `(?:ab)+`         | Igual ao acima, mas sem capturar grupo        |
| `|`         | Alternância (OU lógico)                           | `foo|bar`         | "foo" ou "bar"                                 |

---

## 🧷 5. Escapando Caracteres Especiais

| Caractere     | Como escapar   | Uso Exemplo     | Significado Literal     |
|---------------|----------------|------------------|--------------------------|
| `.`           | `\.`           | `a\.b`           | Casa "a.b"               |
| `*`           | `\*`           | `a\*b`           | Casa "a*b"               |
| `+`           | `\+`           | `a\+b`           | Casa "a+b"               |
| `?`           | `\?`           | `a\?b`           | Casa "a?b"               |
| `{` `}`       | `\{`, `\}`     | `a\{3\}`         | Casa "a{3}"              |
| `(` `)`       | `\(`, `\)`     | `\(abc\)`        | Casa "(abc)"             |
| `[` `]`       | `\[a-z\]`      | Casa literal "[a-z]" |
| `\`           | `\\`           | `"\\d"` em Java  | Casa `\d` (precisa escapar o `\` em Java)     |

---

## 🏁 6. Flags Inline (Modificadores)

| Flag      | Significado                                     | Exemplo           | Efeito                                |
|-----------|-------------------------------------------------|-------------------|----------------------------------------|
| `(?i)`    | Ignora maiúsculas/minúsculas (case-insensitive) | `(?i)abc`         | Casa "abc", "ABC", "AbC", etc.         |
| `(?m)`    | Modo multiline (afeta `^` e `$`)                | `(?m)^abc`        | "abc" no início de qualquer linha      |
| `(?s)`    | Modo "dotall" (ponto casa nova linha)           | `(?s)a.b`         | `.` casa também `\n`                   |
| `(?x)`    | Modo verbose (permite comentários e espaços)     | `(?x) a \s+ b`    | Permite quebra de linha e comentários  |

---

## 🧪 Exemplo de Expressão Regular Completa

**Objetivo:** Validar um endereço de e-mail simples no padrão: `nome@dominio.com`

```java
String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
