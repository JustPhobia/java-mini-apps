package BankingApp.Accounts;

import java.time.LocalDateTime;
import java.util.StringTokenizer;

public class Cheque extends DefaultAccount {

    public Cheque(String user) {
        super(user, "Cheque");
    }

    public void chequeWithdraw(double amount) {
        withdraw(amount, 0, 0);
    }

    public void chequeDeposit(double amount) {
        deposit(amount);
    }

    public void debitOrder() {
        int day, month, year, hour, minutes;
        String uDate = "";
        StringTokenizer st = new StringTokenizer("", "");
        System.out.print("Please input the reference for your debit order: ");
        String uReference = sc.nextLine();
        System.out.print("Please input the amount you will be paying: ");
        double amount = sc.nextDouble();
        System.out.println("Please input the date you would like to deposit[mm/hh/dd/MM/yyyy]: ");
        while (st.countTokens() != 5) {
            uDate = sc.nextLine();
            st = new StringTokenizer(uDate, "/");
        }
        minutes = Integer.parseInt(st.nextToken());
        hour = Integer.parseInt(st.nextToken());
        day = Integer.parseInt(st.nextToken());
        month = Integer.parseInt(st.nextToken());
        year = Integer.parseInt(st.nextToken());
        LocalDateTime date = LocalDateTime.of(year, month, day, hour, minutes);
        System.out.println("Your order was placed successfully!");
        while (true) {
            if (date.equals(LocalDateTime.now())) {
                debitFunds(amount,uReference,date);
                break;
            }
        }
    }
    public  void transfer(double amount, String reference) {
        System.out.println("Please input your transfer amount:" );
        amount = sc.nextDouble();
        System.out.println("Please input the reference of your transfer: ");
        reference = sc.nextLine();
        transferFunds(amount,reference);
    }
}
