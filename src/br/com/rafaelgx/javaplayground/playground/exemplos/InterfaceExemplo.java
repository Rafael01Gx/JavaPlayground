package br.com.rafaelgx.javaplayground.playground.exemplos;

public interface InterfaceExemplo {
    int DEFAULT_AGE = 0;

    void emitirSom();

    default void dormir() {
        System.out.println("Zzz... o animal está dormindo.");
    }

    static void info() {
        System.out.println("Esta é a interface Animal.");
    }

    private void log(String msg) {
        System.out.println("[LOG] " + msg);
    }

    default void comer(String comida) {
        this.log("O animal está comendo " + comida);
    }
}
