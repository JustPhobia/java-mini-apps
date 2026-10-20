package BankingApp.Accounts;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class BankingAppMain {
    public static void main(String[] args) {
        // every account makes its own Scanner, so hand out input one byte at a time
        InputStream real = System.in;
        System.setIn(new InputStream() {
            public int read() throws IOException {
                return real.read();
            }
            public int read(byte[] b, int off, int len) throws IOException {
                return real.read(b, off, 1);
            }
        });

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = input.next();

        Cheque cheque = new Cheque(name);
        Savings savings = new Savings(name);
        Business business = new Business(name);
        FixedDeposit fixed = new FixedDeposit(name);
        Loan loan = new Loan(name, 1000);

        int account = -1;
        while (account != 0) {
            System.out.println("\n1 Cheque  2 Savings  3 Business  4 Fixed Deposit  5 Loan  0 Quit");
            account = input.nextInt();
            if (account == 0) {
                break;
            }
            System.out.println("1 Deposit/Repay  2 Withdraw  3 Balance");
            int action = input.nextInt();
            double amount = 0;
            if (action == 1 || action == 2) {
                System.out.print("Amount: ");
                amount = input.nextDouble();
            }
            switch (account) {
                case 1 -> {
                    if (action == 1) cheque.chequeDeposit(amount);
                    else if (action == 2) cheque.chequeWithdraw(amount);
                    else System.out.println("Balance: " + cheque.getBalance());
                }
                case 2 -> {
                    if (action == 1) savings.deposit(amount);
                    else if (action == 2) savings.withdrawSavings(amount);
                    else System.out.println("Balance: " + savings.getBalance());
                }
                case 3 -> {
                    if (action == 1) business.businessDeposit(amount);
                    else if (action == 2) business.businessWithdraw(amount);
                    else System.out.println("Balance: " + business.getBalance());
                }
                case 4 -> {
                    if (action == 1) fixed.deposit(amount);
                    else if (action == 2) System.out.println("Fixed deposits cannot be withdrawn from yet.");
                    else System.out.println("Balance: " + fixed.getBalance());
                }
                case 5 -> {
                    if (action == 1) loan.repay(amount);
                    else if (action == 2) loan.borrowMore(amount);
                    else System.out.println("You owe: " + loan.getBalance());
                }
                default -> System.out.println("Pick 0-5.");
            }
        }
        System.out.println("Goodbye " + name);
    }
}
