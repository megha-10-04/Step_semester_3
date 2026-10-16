
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

abstract class BankAccount {
    protected String id;
    protected double balance;

    BankAccount(String id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    abstract boolean withdraw(double amount);
}

class SavingsAccount extends BankAccount {
    SavingsAccount(String id, double balance) {
        super(id, balance);
    }

    @Override
    boolean withdraw(double amount) {
        if (balance - amount < 1000) {
            System.out.println(id + " rejected: minimum balance 1000");
            return false;
        }

        balance -= amount;
        System.out.println(id + " balance " + (int) balance);
        return true;
    }
}

class CurrentAccount extends BankAccount {
    CurrentAccount(String id, double balance) {
        super(id, balance);
    }

    @Override
    boolean withdraw(double amount) {
        if (balance - amount < -5000) {
            System.out.println(id + " rejected: overdraft limit 5000");
            return false;
        }

        balance -= amount;
        System.out.println(id + " balance " + (int) balance);
        return true;
    }
}

public class BankAccountWithdrawalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, BankAccount> accounts = new HashMap<>();

        while (sc.hasNext()) {
            String operation = sc.next();

            if (operation.equals("Savings")) {
                String id = sc.next();
                double balance = sc.nextDouble();
                accounts.put(id, new SavingsAccount(id, balance));

            } else if (operation.equals("Current")) {
                String id = sc.next();
                double balance = sc.nextDouble();
                accounts.put(id, new CurrentAccount(id, balance));

            } else if (operation.equals("WITHDRAW")) {
                String id = sc.next();
                double amount = sc.nextDouble();

                if (!accounts.containsKey(id)) {
                    System.out.println("Account not found");
                } else {
                    accounts.get(id).withdraw(amount);
                }
            }
        }

        sc.close();
    }
}
