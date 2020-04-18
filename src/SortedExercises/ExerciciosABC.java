package SortedExercises;

import java.util.Locale;
import java.util.Scanner;

public class ExerciciosABC {
    public static void exercicioNrNatural(String[] args) {


        Scanner sc = new Scanner(System.in);

        System.out.println("Insira um nº inteiro");

        int A;

        A = sc.nextInt();

        if (A < 0) {
            System.out.println("Negativo");
        } else {
            System.out.println("Não negativo");
        }

        sc.close();

    }

    public static void exercicioParImpar(String[] args) {


        Scanner sc = new Scanner(System.in);

        System.out.println("Insira um nº inteiro");

        int A;

        A = sc.nextInt();

        if (A % 2 == 0) {
            System.out.println("Par");
        } else {
            System.out.println("Impar");
        }

        sc.close();

    }

    public static void exercicioMultiplos(String[] args) {


        Scanner sc = new Scanner(System.in);

        System.out.println("Insira 2 numeros inteiros por ordem crescente");

        int A, B;

        A = sc.nextInt();
        B = sc.nextInt();

        if (A % B == 0 || B % A == 0) {
            System.out.println("São multiplos");
        } else {
            System.out.println("Não são multiplos");
        }

        sc.close();

    }

    public static void exercicioHorasJogadas(String[] args) {


        Scanner sc = new Scanner(System.in);

        System.out.println("Insira as horas de inicio e fim do jogo");

        int horaInicial, horaFinal, duracao;

        horaInicial = sc.nextInt();
        horaFinal = sc.nextInt();

        if (horaInicial < horaFinal) {
            duracao = horaFinal - horaInicial;
        } else {
            duracao = 24 - horaInicial + horaFinal;
        }

        System.out.println("O jogo teve a duração de " + duracao + " horas.");
        sc.close();

    }

    public static void exercicioFatura(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Insira o codigo e a quantidade do produto");

        int codprod, quant;
        double total;

        codprod = sc.nextInt();
        quant = sc.nextInt();

        if (codprod == 1) {
            total = quant * 4.0;
        } else if (codprod == 2) {
            total = quant * 4.5;
        } else if (codprod == 3) {
            total = quant * 5.0;
        } else if (codprod == 4) {
            total = quant * 2.0;
        } else {
            total = quant * 1.5;
        }

        System.out.printf("Total: € %.2f%n", total);

        sc.close();
    }

    public static void exercicioIntervalos(String[] args) {

        Scanner sc = new Scanner(System.in);

        double nr = sc.nextDouble();

        if (nr < 0.0 || nr > 100.0) {
            System.out.println("Fora de intervalo");
        } else if (nr <= 25.0) {
            System.out.println("Intervalo [0,25]");
        } else if (nr <= 50.0) {
            System.out.println("Intervalo (25,50]");
        } else if (nr <= 75.0) {
            System.out.println("Intervalo (50,75]");
        } else {
            System.out.println("Intervalo (75,100]");
        }

        sc.close();
    }

    public static void exercicioSistemaEixos(String[] args) {

        Scanner sc = new Scanner(System.in);

        double x = sc.nextDouble();
        double y = sc.nextDouble();

        if (x == 0.0 && y == 0.0) {
            System.out.println("Origem");
        } else if (x == 0.0) {
            System.out.println("Eixo Y");
        } else if (y == 0.0) {
            System.out.println("Eixo X");
        } else if (x > 0.0 && y > 0.0) {
            System.out.println("Q1");
        } else if (x < 0.0 && y > 0.0) {
            System.out.println("Q2");
        } else if (x < 0.0 && y < 0.0) {
            System.out.println("Q3");
        } else {
            System.out.println("Q4");
        }

        sc.close();
    }

    public static void exercicioCalcImposto(String[] args) {
        Scanner sc = new Scanner(System.in);

        double salario = sc.nextDouble();

        double imposto;
        if (salario <= 2000.0) {
            imposto = 0.0;
        } else if (salario <= 3000.0) {
            imposto = (salario - 2000.0) * 0.08;
        } else if (salario <= 4500.0) {
            imposto = (salario - 3000.0) * 0.18 + 1000.0 * 0.08;
        } else {
            imposto = (salario - 4500.0) * 0.28 + 1500.0 * 0.18 + 1000.0 * 0.08;
        }

        if (imposto == 0.0) {
            System.out.println("Isento");
        } else {
            System.out.printf("R$ %.2f%n", imposto);
        }

        sc.close();
    }

    public static void exercicioEstrturaCondicional1(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);

        System.out.println("Insira um numero:\n");
        int num = sc.nextInt();

        if (num < 0) {
            System.out.println("O numero " + num + " é negativo\n");
        } else if (num > 0) {
            System.out.println("O numero " + num + " é positivo\n");
        } else {
            System.out.println("O numero inserido é nulo\n");
        }

        sc.close();
    }
}