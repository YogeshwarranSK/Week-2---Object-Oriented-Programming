package Day11;
import java.util.*;

interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public String getHolderName() { return holderName; }
    public void setHolderName(String holderName) { this.holderName = holderName; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public abstract double calculateInterest();

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public double calculateInterest() {
        return getBalance() * 0.04;
    }

    public void applyForLoan(double amount) {
        System.out.println("Savings Account Loan Request: " + amount);
    }

    public boolean calculateLoanEligibility() {
        return getBalance() >= 5000;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public double calculateInterest() {
        return getBalance() * 0.02;
    }

    public void applyForLoan(double amount) {
        System.out.println("Current Account Loan Request: " + amount);
    }

    public boolean calculateLoanEligibility() {
        return getBalance() >= 10000;
    }
}

public class BankAccountManager {
    public static void processAccounts(List<BankAccount> accounts) {
        for (BankAccount account : accounts) {
            account.displayAccountDetails();
            double interest = account.calculateInterest();
            System.out.println("Calculated Interest: " + interest);
            if (account instanceof Loanable) {
                Loanable l = (Loanable) account;
                l.applyForLoan(50000);
                System.out.println("Loan Eligible: " + l.calculateLoanEligibility());
            }
            System.out.println("---------------------------");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<BankAccount> accounts = new ArrayList<>();

        System.out.print("Enter number of accounts: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for account " + (i + 1));
            System.out.print("Account type (Savings/Current): ");
            String type = sc.nextLine().trim().toLowerCase();

            System.out.print("Account Number: ");
            String accNo = sc.nextLine();

            System.out.print("Holder Name: ");
            String name = sc.nextLine();

            System.out.print("Initial Balance: ");
            double balance = sc.nextDouble();
            sc.nextLine();

            if (type.equals("savings")) {
                accounts.add(new SavingsAccount(accNo, name, balance));
            } else if (type.equals("current")) {
                accounts.add(new CurrentAccount(accNo, name, balance));
            } else {
                System.out.println("Invalid account type. Skipping.");
            }
        }

        System.out.println("\n=== Banking Summary ===");
        processAccounts(accounts);
        sc.close();
    }
}

