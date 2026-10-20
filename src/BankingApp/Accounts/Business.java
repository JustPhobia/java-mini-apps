package BankingApp.Accounts;

public class Business extends DefaultAccount {

    final double overdraftLimit = 5000;

    public Business(String username) {
        super(username, "Business");
    }

    public void businessDeposit(double amount) {
        deposit(amount);
    }

    public void businessWithdraw(double amount) {
        withdraw(amount, -overdraftLimit, Double.MAX_VALUE);
    }

    public String toString() {
        return "Business Account: " + getUsername();
    }
}
