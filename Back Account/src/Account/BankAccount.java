package Account;

public class BankAccount {
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
    public void Withdraw(double withdraw) {
        this.balance = this.balance - withdraw - 5;

    }

    public String toString() {
        return "BankAccount\n{" +
                "accountNumber=" + accountNumber +
                ", accountOwner='" + accountOwner + '\'' +
                ", balance = R$" + balance;
    }
}
