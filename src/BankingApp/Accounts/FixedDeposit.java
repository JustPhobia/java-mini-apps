package BankingApp.Accounts;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class FixedDeposit extends DefaultAccount {
    private LocalDate dateCreated;
    private LocalDate fixedDate;

    FixedDeposit(String username) {
        super(username, "Fixed Deposit");
        boolean validYear = false;
        int year = 0;
        dateCreated = LocalDate.now();
        System.out.println("What year would you like this to deposit to end?");
        while (!validYear) {
            year = sc.nextInt();
            if (year > dateCreated.getYear()) {
                validYear = true;
                fixedDate = LocalDate.of(year, dateCreated.getMonth(), dateCreated.getDayOfMonth());
            } else {
                System.out.println("Deposit end must be at least one year in the future.");
                System.out.println("Re-enter a valid year please:");
            }
        }

    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }
    public LocalDate getFixedDate() {
        return fixedDate;
    }

    public void deposit(double amount) {super.deposit(amount);}

    public void withdraw(double amount) {
        LocalDate now = LocalDate.now();
        Period diff =Period.between(fixedDate, now);
        if (now.isAfter(fixedDate)) {
            super.withdraw(amount,0,0);
        }else{
            System.out.println("This will make a 5% charge on your fixed deposit. Are you sure? [Y/N]");
            if (sc.nextLine().toLowerCase().charAt(0)== 'Y' ) {

            }
        }
    }
}
