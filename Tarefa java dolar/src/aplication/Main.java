package aplication;

import util.CurrencyConverter;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double dolar,quantidade;

        System.out.println("Digite o valor do dolar: ");
        dolar = sc.nextDouble();

        System.out.println("Digite a quantidade de dolares a serem comprados: ");
        quantidade = sc.nextDouble();

        System.out.printf("Total a ser pago em reais: R$%.2f",CurrencyConverter.Conversor(dolar,quantidade));

        sc.close();
    }
}