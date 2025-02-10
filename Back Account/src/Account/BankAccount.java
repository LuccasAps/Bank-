package Account;

public abstract class BankAccount implements AccountInterface, Comparable<BankAccount> {
    //implementar cpf nas contas!!!
    protected int accountNumber;
    protected String accountOwner;
    protected double balance = 0;

    public BankAccount(int accountNumber, String accountOwner, double firstdeposit) {
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

    public double getBalance() {
        return balance;
    }

    public void Deposit(double deposit) {
        this.balance += deposit;
    }

    public int compareTo(BankAccount other) {
        return accountOwner.compareTo(other.accountOwner);
    }


    public String toString() {
        return "AccountNumber = " + accountNumber +
                ", accountOwner = " + accountOwner +
                ", balance = R$" + balance;
    }
}
