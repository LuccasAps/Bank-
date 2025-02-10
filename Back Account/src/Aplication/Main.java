package Aplication;
import Account.BankAccount;
import Account.BussinesAccount;
import Account.NormalAccount;
import Services.BankAccountServices;

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

                    while(BankAccountServices.VerificaConta(lista,accountNumber)){
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

                        lista.add(new NormalAccount(accountNumber, accountOwner, depositAmount));

                        System.out.println(lista.get(BankAccountServices.RetornaIndex(lista, accountNumber)).toString());
                    }
                    else{

                        lista.add(new NormalAccount(accountNumber, accountOwner));

                        System.out.println(lista.get(BankAccountServices.RetornaIndex(lista, accountNumber)).toString());
                    }
                    break;

                case 2:
                    System.out.println("Enter a number account:");
                    accountNumber = sc.nextInt();

                    while(BankAccountServices.VerificaConta(lista,accountNumber)){
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

                        System.out.println(lista.get(BankAccountServices.RetornaIndex(lista, accountNumber)).toString());
                    }
                    else{

                        lista.add(new BussinesAccount(accountNumber, accountOwner, limite));

                        System.out.println(lista.get(BankAccountServices.RetornaIndex(lista, accountNumber)).toString());
                    }
                    break;

                case 3:
                    int numAccount;
                    System.out.println("Enter a number account:");
                    numAccount = sc.nextInt();

                    while (!BankAccountServices.VerificaNum(lista,numAccount)){
                        System.out.println("Numero de conta inexistente, digite novamente: ");
                        numAccount = sc.nextInt();
                    }

                    System.out.println("Digite o novo nome");
                    String nome = sc.next();
                    lista.get(BankAccountServices.RetornaIndex(lista, numAccount)).setAccountOwner(nome);

                    System.out.println(lista.get(BankAccountServices.RetornaIndex(lista, numAccount)).toString());
                    break;

                case 4:
                    for (BankAccount bankAccount : lista) {
                        System.out.println(bankAccount.toString());
                    }
                    break;

                case 5:
                    System.out.println("Digite o numero da conta para o deposito:");
                    int numeroConta = sc.nextInt();

                    while (!BankAccountServices.VerificaNum(lista,numeroConta)){
                        System.out.println("Numero de conta inexistente, digite novamente: ");
                        numeroConta = sc.nextInt();
                    }

                    System.out.println("Digite o valor do deposito:");
                    int depositAmount = sc.nextInt();
                    lista.get(BankAccountServices.RetornaIndex(lista, numeroConta)).Deposit(depositAmount);

                    System.out.println(lista.get(BankAccountServices.RetornaIndex(lista, numeroConta)).toString());

                    break;

                case 6:
                    System.out.println("Digite a o numero da conta para o saque:");
                    int numeroConta2 = sc.nextInt();

                    while (!BankAccountServices.VerificaNum(lista,numeroConta2)){
                        System.out.println("Numero de conta inexistente, digite novamente: ");
                        numeroConta2 = sc.nextInt();
                    }
                    System.out.println("Digite o valor do saque:");
                    int saqueAmount = sc.nextInt();

                    while(saqueAmount > lista.get(BankAccountServices.RetornaIndex(lista, numeroConta2)).getBalance() - 5) {
                            System.out.println("O valor de saque excede o montante existente na conta, digite novamente: ");
                            saqueAmount = sc.nextInt();
                    }
                    lista.get(BankAccountServices.RetornaIndex(lista, numeroConta2)).Withdraw(saqueAmount);

                    System.out.println(lista.get(BankAccountServices.RetornaIndex(lista, numeroConta2)).toString());

                    break;

                default:
                        System.out.println("Opção Invalida");
            }

        }while(num != 0);
        sc.close();
    }
}