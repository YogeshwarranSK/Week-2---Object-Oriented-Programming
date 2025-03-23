package Day7.Access_Modifiers;
import java.util.Scanner;
class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
class SavingsAccount extends BankAccount {
    private double interestRate;
    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }
    public void displaySavingsAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + getBalance());
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}
public class BankAccountManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        System.out.print("Enter Account Holder: ");
        String holder = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();
        System.out.print("Enter Interest Rate: ");
        double rate = sc.nextDouble();
        SavingsAccount sa = new SavingsAccount(accNo, holder, balance, rate);
        sa.displaySavingsAccount();
        System.out.print("Update Balance: ");
        double newBalance = sc.nextDouble();
        sa.setBalance(newBalance);
        System.out.println("\nUpdated Account Details:");
        sa.displaySavingsAccount();
    }
}

