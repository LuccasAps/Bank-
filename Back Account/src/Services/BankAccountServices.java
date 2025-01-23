package Services;

import Account.BankAccount;

import java.util.List;

public class BankAccountServices {

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
