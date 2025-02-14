package Aplication;
import Account.BankAccount;
import Account.BussinesAccount;
import Account.NormalAccount;
import Services.BankAccountServices;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<BankAccount> Contas = new ArrayList<>();
        int num;
        do{
            System.out.println(" 0. Sair\n 1. Criar conta\n 2. Criar conta Empresarial\n 3. Alterar informações da conta\n 4. Listar contas\n 5. Depositar\n 6. Sacar\n");
            num = sc.nextInt();
            switch (num){
                case 0:
                    break;

                case 1:
                    System.out.println("Enter a number account:");
                    int NumeroConta = sc.nextInt();

                    while(BankAccountServices.VerificaConta(Contas,NumeroConta)){
                        System.out.println("Id ja registrado, digite novamente: ");
                        NumeroConta = sc.nextInt();
                    }

                    System.out.println("Enter a name of owner account:");
                    String accountOwner;
                    accountOwner = sc.next();

                    System.out.println("Você deseja fazer um primeiro deposito(y/n)?");
                    char choice;
                    choice = sc.next().toLowerCase().charAt(0);

                    if (choice == 'y'){
                        System.out.println("Digite o valor do deposito: ");
                        double depositAmount = sc.nextInt();
                        BankAccount bacc = new NormalAccount(NumeroConta, accountOwner, depositAmount);
                        Contas.add(bacc);

                        System.out.println("Conta Criada com sucesso!");

                        System.out.println(bacc);
                    }
                    else{

                        BankAccount bacc = new NormalAccount(NumeroConta, accountOwner);
                        Contas.add(bacc);

                        System.out.println("Conta Criada com sucesso!");

                        System.out.println(bacc);
                    }
                    break;

                case 2:
                    System.out.println("Enter a number account:");
                    int accountNumber = sc.nextInt();

                    while(BankAccountServices.VerificaConta(Contas,accountNumber)){
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

                        BankAccount bacc = new BussinesAccount(accountNumber, accountOwner, limite, depositAmount);
                        Contas.add(bacc);

                        System.out.println("Conta Criada com sucesso!");

                        System.out.println(bacc);
                    }
                    else{

                        BankAccount bacc = new BussinesAccount(accountNumber, accountOwner, limite);
                        Contas.add(bacc);

                        System.out.println("Conta Criada com sucesso!");
                        System.out.println(bacc);

                    }
                    /*int index2 = 0;
                    for(int i = 0; i < Contas.size(); i++) {
                        if(Contas.get(i).getAccountNumber() == accountNumber)
                        {
                            index2 = i;
                            break;
                        }
                        else {
                            index2 = -1;
                        }
                    }
                    System.out.println(Contas.get(index2).toString());
                    System.out.println(Contas.get(index).toString());*/
                    break;

                case 3:
                    int numAccount;
                    System.out.println("Enter a number account:");
                    numAccount = sc.nextInt();

                    while (!BankAccountServices.VerificaNum(Contas,numAccount)){
                        System.out.println("Numero de conta inexistente, digite novamente: ");
                        numAccount = sc.nextInt();
                    }

                    System.out.println("Digite o novo nome");
                    String nome = sc.next();


                    Contas.get(BankAccountServices.RetornaIndex(Contas, numAccount)).setAccountOwner(nome);
                    System.out.println(Contas.get(BankAccountServices.RetornaIndex(Contas, numAccount)).toString());


                   System.out.println("Conta alterada com sucesso!");
                    //System.out.println(Contas.get(BankAccountServices.RetornaIndex(Contas, numAccount)).toString());
                    break;

                case 4:
                    Contas.sort((p1, p2) -> p1.getAccountOwner().compareTo(p2.getAccountOwner()));
                    //Contas.sort(Comparator.comparing(BankAccount::getAccountOwner));
                    Contas.forEach(System.out::println);
                    break;

                case 5:
                    System.out.println("Digite o numero da conta para o deposito:");
                    int numeroConta = sc.nextInt();

                    while (!BankAccountServices.VerificaNum(Contas,numeroConta)){
                        System.out.println("Numero de conta inexistente, digite novamente: ");
                        numeroConta = sc.nextInt();
                    }

                    System.out.println("Digite o valor do deposito:");
                    int depositAmount = sc.nextInt();
                    Contas.get(BankAccountServices.RetornaIndex(Contas, numeroConta)).Deposit(depositAmount);

                    System.out.println(Contas.get(RetornaIndex(Contas, numeroConta)).toString());

                    break;

                case 6:
                    System.out.println("Digite a o numero da conta para o saque:");
                    int numeroConta2 = sc.nextInt();

                    while (!BankAccountServices.VerificaNum(Contas,numeroConta2)){
                        System.out.println("Numero de conta inexistente, digite novamente: ");
                        numeroConta2 = sc.nextInt();
                    }
                    System.out.println("Digite o valor do saque:");
                    int saqueAmount = sc.nextInt();

                    while(saqueAmount > Contas.get(BankAccountServices.RetornaIndex(Contas, numeroConta2)).getBalance() - 5) {
                            System.out.println("O valor de saque excede o montante existente na conta, digite novamente: ");
                            saqueAmount = sc.nextInt();
                    }
                    Contas.get(BankAccountServices.RetornaIndex(Contas, numeroConta2)).Withdraw(saqueAmount);


                    System.out.println(Contas.get(BankAccountServices.RetornaIndex(Contas, numeroConta2)).toString());

                    break;

                default:
                        System.out.println("Opção Invalida");
            }

        }while(num != 0);
        sc.close();
    }

    public static int RetornaIndex(List<BankAccount> lista, int numAccount){
        int index;
        for(index = 0; index < lista.size(); index++) {
            if (lista.get(index).getAccountNumber() == numAccount)
            {
                return index;
            }
            else {
                index = -1;
            }
        }
        return index;
    }
}