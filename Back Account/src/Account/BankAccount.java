package Account;

public class BankAccount {

    private int accountNumber;
    private String accountOwner;
    private int balance = 0;

    public BankAccount(int accountNumber, String accountOwner, int firstdeposit) {
        this.accountNumber = accountNumber;
        this.accountOwner = accountOwner;
        Deposit(firstdeposit);
    }

    public BankAccount(int accountNumber, String accountOwner) {
        this.accountOwner = accountOwner;
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }


    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public int getBalance() {
        return balance;
    }
    public void Deposit(int deposit) {
        this.balance += deposit;
    }
    public void Withdraw(int withdraw) {
        this.balance = this.balance - withdraw - 5;
    }

    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", accountOwner='" + accountOwner + '\'' +
                ", balance = R$" + balance +
                '}';
    }
}
