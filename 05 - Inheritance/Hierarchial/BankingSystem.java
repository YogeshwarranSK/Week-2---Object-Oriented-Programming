package Day10.Hierarchial;
import java.util.Scanner;
class BankAccount {
    protected String accountNumber;
    protected double balance;
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public void displayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}
class SavingsAccount extends BankAccount {
    private double interestRate;
    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    public void displayAccountType() {
        displayInfo();
        System.out.println("Account Type: Savings");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
class CheckingAccount extends BankAccount {
    private double withdrawalLimit;
    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }
    public void displayAccountType() {
        displayInfo();
        System.out.println("Account Type: Checking");
        System.out.println("Withdrawal Limit: $" + withdrawalLimit);
    }
}
class FixedDepositAccount extends BankAccount {
    private int maturityPeriod;
    public FixedDepositAccount(String accountNumber, double balance, int maturityPeriod) {
        super(accountNumber, balance);
        this.maturityPeriod = maturityPeriod;
    }
    public void displayAccountType() {
        displayInfo();
        System.out.println("Account Type: Fixed Deposit");
        System.out.println("Maturity Period: " + maturityPeriod + " months");
    }
}
public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        System.out.print("Enter Balance: ");
        double bal = sc.nextDouble();
        sc.nextLine();
        System.out.print("Choose Account Type (1-Savings, 2-Checking, 3-FixedDeposit): ");
        int choice = sc.nextInt();
        if(choice == 1) {
            System.out.print("Enter Interest Rate: ");
            double rate = sc.nextDouble();
            SavingsAccount sa = new SavingsAccount(accNo, bal, rate);
            sa.displayAccountType();
        } else if(choice == 2) {
            System.out.print("Enter Withdrawal Limit: ");
            double limit = sc.nextDouble();
            CheckingAccount ca = new CheckingAccount(accNo, bal, limit);
            ca.displayAccountType();
        } else if(choice == 3) {
            System.out.print("Enter Maturity Period (months): ");
            int period = sc.nextInt();
            FixedDepositAccount fda = new FixedDepositAccount(accNo, bal, period);
            fda.displayAccountType();
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
