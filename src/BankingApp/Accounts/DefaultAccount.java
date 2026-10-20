package BankingApp.Accounts;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class DefaultAccount {
    Scanner sc = new Scanner(System.in);
    private String username;
    private String accountNumber;
    private String accountType;
    private double balance;
    private String miniRecords;
    StringBuilder tempAccountNumber = new StringBuilder();

    protected DefaultAccount(String username, String accountType) {
        LocalDateTime now = LocalDateTime.now();
        Random rand = new Random();
        this.accountType = accountType;
        this.username = username;
        int tempNum = rand.nextInt(1000000, 9999999);
        tempAccountNumber.append(tempNum);
        if (now.getSecond()<10){
            tempAccountNumber.append("0");
        }
        tempAccountNumber.append(now.getSecond());
        this.accountNumber = tempAccountNumber.toString();
        this.balance = 0;
    }

    protected String getAccountType() {
        return accountType;
    }

    protected String getUsername() {
        return username;
    }
    protected void setUsername(String username) {
        this.username = username;
    }
    protected String getAccountNumber() {
        return accountNumber;
    }
    protected void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    protected void setBalance(double balance) {
        this.balance = balance;
    }
    protected double getBalance() {
        return balance;
    }
    protected void  deposit(double amount) {
        this.balance += amount;
        this.miniRecords = this.username+" Deposited: " + amount;
        System.out.println("Your new balance is: " + this.balance);
    }

    protected void withdraw(double amount, double minimumBalance, double withdrawalLimit) {
        if (balance-amount>=minimumBalance && balance <= withdrawalLimit) {
            this.balance -= amount;
            this.miniRecords = this.username+" Withdrew: " + amount;
            System.out.println("Your new balance is: " + this.balance);
        }else{
            System.out.println("Insufficient funds Or Withdrawal limit reached!");
        }
    }

    protected void transferFunds(double amount, String reference) {
        this.balance -= amount;
        this.miniRecords = this.username+" Transferred: " + amount + " Reference: "+reference;
        System.out.println("Transfer successful!");
    }

    protected void debitFunds(double amount, String reference, LocalDateTime date) {
            this.balance -= amount;
            this.miniRecords = this.username+" Transferred: " + amount + " Reference: " + reference+" Due for: "+date.toString();
            System.out.println("Your debit order "+"Transferred: " + amount + ", Reference: " + reference+"new balance is: " + this.balance);
    }

}
