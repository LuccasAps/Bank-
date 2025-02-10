package Account;

public class BussinesAccount extends BankAccount{

    private double loanLimit;
    private double loanbalance = 0.0;

    public BussinesAccount(int accountNumber, String accountOwner, double firstdeposit, double loanLimit) {
        super(accountNumber, accountOwner, firstdeposit);
        this.loanLimit = loanLimit;
    }

    public BussinesAccount(int accountNumber, String accountOwner, double loanLimit) {
        super(accountNumber, accountOwner);
        this.loanLimit = loanLimit;
    }

    public double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(double loanLimit) {
        this.loanLimit = loanLimit;
    }

    public double getLoanbalance() {
        return loanbalance;
    }

    public void loan(double amount){
        if(amount <= loanLimit){
            Deposit(amount);
            this.loanbalance += amount;
        }
        else{
            System.out.println("Limite Insuficiente");
        }
    }

    @Override
    public void Withdraw(double amount) {
        balance -= amount;
    }


    @Override
    public String toString() {
        return "Bussines Account " + super.toString() + ", Limite de Emprestimo = R$" + loanLimit + ", Debito de Emprestimo = R$" + loanbalance;
        }
}
