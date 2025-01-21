package Aplication;
import Account.BankAccount;
import Account.BussinesAccount;

import java.util.Scanner;
import java.util.Locale;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<BankAccount> lista = new ArrayList<>();
        int num;
        do{
            System.out.println(" 0. Sair\n 1. Criar conta\n 2. Criar conta Empresarial\n 3. Alterar informações da conta\n 4. Listar contas\n 5. Depositar\n 6. Sacar\n");
            num = sc.nextInt();
            switch (num){
                case 0:
                    break;

                case 1:

                    System.out.println("Enter a number account:");
                    int accountNumber = sc.nextInt();

                    while(VerificaConta(lista,accountNumber)){
                        System.out.println("Id ja registrado, digite novamente: ");
                        accountNumber = sc.nextInt();
                    }
                    System.out.println("Enter a name of owner account:");
                    String accountOwner = sc.next();

                    System.out.println("Você deseja fazer um primeiro deposito(y/n)?");

                    char choice = sc.next().charAt(0);

                    if (choice == 'y'){
                        System.out.println("Digite o valor do deposito: ");
                        double depositAmount = sc.nextInt();

                        lista.add(new BankAccount(accountNumber, accountOwner, depositAmount));
                        int index = 0;
                        for(int i = 0; i < lista.size(); i++) {
                            if(lista.get(i).getAccountNumber() == accountNumber)
                            {
                                index = i;
                            }
                            else {
                                index = -1;
                            }
                        }
                        System.out.println(lista.get(index).toString());
                    }
                    else{

                        lista.add(new BankAccount(accountNumber, accountOwner));
                        int index = 0;
                        for(int i = 0; i < lista.size(); i++) {
                            if(lista.get(i).getAccountNumber() == accountNumber)
                            {
                                index = i;
                            }
                            else {
                                index = -1;
                            }
                        }
                        System.out.println(lista.get(index).toString());
                    }
                    break;

                case 2:

                    System.out.println("Enter a number account:");
                    accountNumber = sc.nextInt();

                    while(VerificaConta(lista,accountNumber)){
                        System.out.println("Id ja registrado, digite novamente: ");
                        accountNumber = sc.nextInt();
                    }
                    System.out.println("Enter a name of owner account:");
                    accountOwner = sc.next();

                    double limite;
                    do {
                        System.out.println("Digite o limite de empresitmo desejado");
                         limite = sc.nextDouble();
                    }
                    while(limite > 10000.00);


                    System.out.println("Você deseja fazer um primeiro deposito(y/n)?");

                    choice = sc.next().charAt(0);

                    if (choice == 'y'){
                        System.out.println("Digite o valor do deposito: ");
                        double depositAmount = sc.nextInt();

                        lista.add(new BussinesAccount(accountNumber, accountOwner, depositAmount, limite));
                        int index = 0;
                        for(int i = 0; i < lista.size(); i++) {
                            if(lista.get(i).getAccountNumber() == accountNumber)
                            {
                                index = i;
                            }
                            else {
                                index = -1;
                            }
                        }
                        System.out.println(lista.get(index).toString());
                    }
                    else{

                        lista.add(new BankAccount(accountNumber, accountOwner, limite));
                        int index = 0;
                        for(int i = 0; i < lista.size(); i++) {
                            if(lista.get(i).getAccountNumber() == accountNumber)
                            {
                                index = i;
                            }
                            else {
                                index = -1;
                            }
                        }
                        System.out.println(lista.get(index).toString());
                    }
                    break;

                case 3:

                    int numAccount;
                    System.out.println("Enter a number account:");
                    numAccount = sc.nextInt();

                    while (!VerificaNum(lista,numAccount)){
                        System.out.println("Numero de conta inexistente, digite novamente: ");
                        numAccount = sc.nextInt();
                    }
                    int index2 = 0;
                    for(int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getAccountNumber() == numAccount) {
                            index2 = i;
                        } else {
                            index2 = -1;
                        }

                    }

                    System.out.println("Digite o novo nome");
                    String nome = sc.next();
                    lista.get(index2).setAccountOwner(nome);

                    System.out.println(lista.get(index2).toString());
                    break;

                case 4:

                    for (BankAccount bankAccount : lista) {
                        System.out.println(bankAccount.toString());
                    }
                    break;

                case 5:
                    System.out.println("Digite o numero da conta para o deposito:");
                    int numeroConta = sc.nextInt();

                    while (!VerificaNum(lista,numeroConta)){
                        System.out.println("Numero de conta inexistente, digite novamente: ");
                        numeroConta = sc.nextInt();
                    }
                    int index3 = 0;
                    for(int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getAccountNumber() == numeroConta) {
                            index3 = i;
                        } else {
                            index3 = -1;
                        }
                    }
                    System.out.println("Digite o valor do deposito:");
                    int depositAmount = sc.nextInt();
                    lista.get(index3).Deposit(depositAmount);

                    System.out.println(lista.get(index3).toString());

                    break;

                case 6:
                    System.out.println("Digite a o numero da conta para o saque:");
                    int numeroConta2 = sc.nextInt();

                    while (!VerificaNum(lista,numeroConta2)){
                        System.out.println("Numero de conta inexistente, digite novamente: ");
                        numeroConta2 = sc.nextInt();
                    }
                    int index4 = 0;
                    for(int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getAccountNumber() == numeroConta2) {
                            index4 = i;
                        } else {
                            index4 = -1;
                        }
                    }

                    System.out.println("Digite o valor do saque:");
                    int saqueAmount = sc.nextInt();

                    double balance = lista.get(index4).getBalance();

                    balance = balance - 5;

                    System.out.println(balance);

                    while(saqueAmount > balance) {
                            System.out.println("O valor de saque excede o montante existente na conta, digite novamente: ");
                            saqueAmount = sc.nextInt();
                    }
                    lista.get(index4).Withdraw(saqueAmount);

                    System.out.println(lista.get(index4).toString());

                    break;

                default:
                        System.out.println("Opção Invalida");
            }

        }while(num != 0);
        sc.close();
    }
    public static boolean VerificaConta(List<BankAccount> lista, int accountnum){
        BankAccount account = lista.stream().filter(x -> x.getAccountNumber() == accountnum).findFirst().orElse(null);
        return account != null;
    }

    public static boolean VerificaNum(List<BankAccount> lista, int numAccount){
        int k = 0;
        boolean flag = false;
        while(k < lista.size()) {
            if (lista.get(k).getAccountNumber() == numAccount) {
                flag = true;
                break;
            }
            k++;
        }
        return flag;
    }
}