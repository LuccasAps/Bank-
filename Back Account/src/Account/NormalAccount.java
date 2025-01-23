package Account;

public class NormalAccount extends BankAccount {
    public NormalAccount(int accountNumber, String accountOwner, double firstdeposit) {
        super(accountNumber, accountOwner, firstdeposit);
    }

    public NormalAccount(int accountNumber, String accountOwner) {
        super(accountNumber, accountOwner);
    }
    @Override
    public void Withdraw(double withdraw) {
        this.balance = this.balance - withdraw - 5;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}