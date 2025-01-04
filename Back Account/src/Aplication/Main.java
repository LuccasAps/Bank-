package Aplication;
import Account.BankAccount;
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
            System.out.println(" 0. Sair\n 1. Criar conta\n 2. Alterar informações da conta\n 3. Listar contas\n");
            num = sc.nextInt();
            switch (num){
                case 1:
                    System.out.println("Enter a number account:");
                    int accountNumber = sc.nextInt();

                    while(VerificaConta(lista,accountNumber)){
                        System.out.println("Id ja registrado, digite novamente: ");
                        accountNumber = sc.nextInt();
                    }
                    System.out.println("Enter a name of owner account:");
                    String accountOwner = sc.next();

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
                    break;
                case 2:

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
                case 3:
                    for (BankAccount bankAccount : lista) {
                        System.out.println(bankAccount.toString());
                    }
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