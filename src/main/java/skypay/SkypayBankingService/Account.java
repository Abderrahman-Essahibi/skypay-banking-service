package skypay.SkypayBankingService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor

public class Account implements AccountService {
    @Getter @AllArgsConstructor
    private static class Transaction {
        private final String date;
        private final int amount;

    }

    private final List<Transaction> transactions = new ArrayList<>();
    private int balance = 0;

    private void validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
    }

    // A helper method that gives us a "date" when we record a transaction ( to grantee clean code )
    private String getTodayDate() {
        return "N/A";
    }

    @Override
    public void deposit(int amount) {
        validateAmount(amount);
        balance += amount;
        transactions.add(new Transaction(getTodayDate(), amount));
    }

    @Override
    public void withdraw(int amount) {
        validateAmount(amount);
        if (amount > balance ) {
            throw new IllegalStateException("Insufficient funds");
        }
        balance -= amount;
        transactions.add(new Transaction(getTodayDate(), -amount));
    }

    @Override
    public void printStatement() {
        System.out.println("DATE       | AMOUNT | BALANCE");
        int runningBalance = 0;

        List<Transaction> reversed = new ArrayList<>(transactions);
        Collections.reverse(reversed);

        for (Transaction t : reversed) {
            runningBalance += t.getAmount();
            System.out.printf("%s | %6d | %7d\n", t.getDate(), t.getAmount(), runningBalance);
        }
    }


    // Helper for test input with specific dates
    public void addTransaction(String date, int amount) {
        if (amount == 0) return;
        balance += amount;
        transactions.add(new Transaction(date, amount));
    }

}
