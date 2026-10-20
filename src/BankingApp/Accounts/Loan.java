package BankingApp.Accounts;

public class Loan extends DefaultAccount {

    private float interestRate = (float) 0.10;

    public Loan(String username, double amount) {
        super(username, "Loan");
        setBalance(amount);
    }

    public void applyInterest() {
        setBalance(getBalance() + getBalance() * interestRate);
        System.out.println("You now owe: " + getBalance());
    }

    public void borrowMore(double amount) {
        setBalance(getBalance() + amount);
        System.out.println("You now owe: " + getBalance());
    }

    public void repay(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
            System.out.println("You now owe: " + getBalance());
        } else {
            System.out.println("Repayment must be more than 0 and not more than you owe!");
        }
    }

    public String toString() {
        return "Loan Account: " + getUsername();
    }
}
