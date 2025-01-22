package Account;

public class NormalAccount extends BankAccount {
    public NormalAccount(int accountNumber, String accountOwner, double firstdeposit) {
        super(accountNumber, accountOwner, firstdeposit);
    }

    public NormalAccount(int accountNumber, String accountOwner) {
        super(accountNumber, accountOwner);
    }

    @Override
    public int getAccountNumber() {
        return super.getAccountNumber();
    }

    @Override
    public String getAccountOwner() {
        return super.getAccountOwner();
    }

    @Override
    public void setAccountOwner(String accountOwner) {
        super.setAccountOwner(accountOwner);
    }

    @Override
    public double getBalance() {
        return super.getBalance();
    }

    @Override
    public void Deposit(double deposit) {
        super.Deposit(deposit);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void Withdraw(double withdraw) {
        this.balance = this.balance - withdraw - 5;
    }
}
