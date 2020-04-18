package SortedExercises;

import java.util.Scanner;

public class ExercicioEstrutruraSequencial {
    public static void exercicioSoma(String[] args) {

        Scanner sc = new Scanner(System.in);

        int A, B, soma;

        A = sc.nextInt();
        B = sc.nextInt();

        soma = A + B;

        System.out.println("Total = " + soma);

        sc.close();
    }

    public static void exercicioRaio(String[] args) {

        System.out.println("Insira o valor do raio");
        Scanner sc = new Scanner(System.in);

        double area, radius;

        radius = sc.nextInt();

        area = Math.PI * Math.pow(radius, 2);

        System.out.printf("Area do circulo é: area=%.4f%n", area);
    }

    public static void exercicioDiferencaProduto(String[] args) {

        System.out.println("Insira 4 valores:");
        Scanner sc = new Scanner(System.in);

        int A, B, C, D, diferenca;

        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
        D = sc.nextInt();

        diferenca = (A * B - C * D);

        System.out.println("A diferença do produto é:" + diferenca);
    }

    public static void exercicioSalario(String[] args) {

        System.out.println("Insira nº de funcionário, horas trabalhadas,valor-hora");
        Scanner sc = new Scanner(System.in);

        int nrfunc;
        double horastrb, vhora, salario;

        nrfunc = sc.nextInt();
        horastrb = sc.nextDouble();
        vhora = sc.nextDouble();

        salario = horastrb * vhora;

        System.out.printf("O montante do salario do funcionário nrº" + nrfunc + " é salário= €%.2f%n", salario);
    }

    public static void exercicioCalcAreas
            (String[] args) {

        System.out.println("Insira 3 valores para cálculo de areas");
        Scanner sc = new Scanner(System.in);

        double A, B, C, areaTriang, areaCir, areaTrap, areaQuad, areaRect;

        A = sc.nextDouble();
        B = sc.nextDouble();
        C = sc.nextDouble();

        areaTriang = A * C / 2.0;
        areaCir = Math.PI * Math.pow(C, 2);
        areaTrap = (A + B) / 2.0 * C;
        areaQuad = B * B;
        areaRect = A * B;

        System.out.printf("O triângulo tem uma area de %.3f\n", areaTriang);
        System.out.printf("O círculo tem uma area de %.3f\n", areaCir);
        System.out.printf("O trapezio tem uma area de %.3f\n", areaTrap);
        System.out.printf("O quadrado tem uma area de %.3f\n", areaQuad);
        System.out.printf("O retângulo tem uma area de %.3f\n", areaRect);

        sc.close();
    }
}
