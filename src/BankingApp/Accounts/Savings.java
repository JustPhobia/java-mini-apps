package BankingApp.Accounts;

import java.util.concurrent.ThreadLocalRandom;

public class Savings extends DefaultAccount{

    private float interestRate =(float) 0.075;
    final float minimumBalance = 50;
    private double withdrawalLimit;


    public Savings(String username) {
        super(username, "Savings");
        double temp= 0;
        withdrawalLimit=1000;
        System.out.println("Please enter your balance (Greater than R50):");
        while (temp<minimumBalance) {
            temp=sc.nextDouble();
        }
        setBalance(temp);
    }

    private void applyInterest()  {
        while (true) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            deposit(getBalance() * interestRate);
        }
    }
    public  void withdrawSavings(double amount) {

        withdraw(amount, minimumBalance, withdrawalLimit);
    }
    public void setWithdrawalLimit(double withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }
    public String toString() {
        return "Savings Account: " + getUsername();
    }
}
