package br.com.rafaelgx.javaplayground.playground.exemplos;

public class SobrecargaDeMetodos {
    public int somar(int a, int b) {
        return a + b;
    }

    public int somar(int a, int b, int c) {
        return a + b + c;
    }

    public double somar(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        SobrecargaDeMetodos calc = new SobrecargaDeMetodos();
        int resultado1 = calc.somar(5, 10);
        System.out.println("Soma de 5 e 10: " + resultado1);
        int resultado2 = calc.somar(5, 10, 15);
        System.out.println("Soma de 5, 10 e 15: " + resultado2);
        double resultado3 = calc.somar((double)5.5F, (double)10.5F);
        System.out.println("Soma de 5.5 e 10.5: " + resultado3);
    }
}