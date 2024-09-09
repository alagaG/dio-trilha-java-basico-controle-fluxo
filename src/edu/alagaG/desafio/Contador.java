package edu.alagaG.desafio;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Contador {

    private static final Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    public static void main(String[] args) {
        contarSemErro();
    }

    public static void contarSemErro() {
        try {
            contar();
        } catch (ParametrosInvalidosException e) {
            System.out.println("O segundo parâmetro deve ser maior que o primeiro!\nDeseja tentar novamente? [SIM/NÃO]");
            String answer = scanner.next();
            if (Objects.equals(answer, "SIM")) {
                System.out.println();
                contarSemErro();
            }
        }
    }

    public static void contar() throws ParametrosInvalidosException {
        System.out.println(
                "Para realizar a contagem são necessários 2 números\n"+
                "Obs.: O 1° número deve ser menor que o 2°.\n"
                );
        int num1 = pedirInteiro();
        int num2 = pedirInteiro();

        if (num1 > num2) throw new ParametrosInvalidosException();

        int interacoes = num2 - num1;
        for (int i=1; i<=interacoes; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }

    private static int pedirInteiro() {
        try {
            System.out.print("Por favor digite um número inteiro: ");
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            if (scanner.hasNext()) scanner.nextLine();
            System.out.println("Valor inválido! Utilize apenas caracteres numéricos.\n");
            return pedirInteiro();
        }
    }

}
