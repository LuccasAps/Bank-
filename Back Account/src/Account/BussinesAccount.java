package Account;

public class BussinesAccount extends BankAccount{

    private Double loanLimit;
    private Double loanbalance = 0.0;

    public BussinesAccount(int accountNumber, String accountOwner, double firstdeposit, Double loanLimit) {
        super(accountNumber, accountOwner, firstdeposit);
        this.loanLimit = loanLimit;
    }

    public BussinesAccount(int accountNumber, String accountOwner, Double loanLimit) {
        super(accountNumber, accountOwner);
        this.loanLimit = loanLimit;
    }

    public Double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {
        this.loanLimit = loanLimit;
    }

    public double getLoanbalance() {
        return loanbalance;
    }

    @Override
    public void Withdraw(double amount) {
        balance -= amount;
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
    public String toString() {
        return super.toString() + ", Limite de Emprestimo = R$" + loanLimit + ", Debito de Emprestimo = R$" + loanbalance + "}";
        }
}
