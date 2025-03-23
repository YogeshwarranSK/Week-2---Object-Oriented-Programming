package Day8;
import java.util.Scanner;

class BankAccount {
    static String bankName = "OpenAI Bank";
    private static int totalAccounts = 0;
    private final String accountNumber;
    private final String accountHolderName;

     BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public void displayAccountDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
        } else {
            System.out.println("Invalid account object.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account holder's name: ");
        String holderName = scanner.nextLine();

        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        BankAccount account = new BankAccount(holderName, accountNumber);

        account.displayAccountDetails();
        System.out.println("\nTotal Accounts: " + BankAccount.getTotalAccounts());

        scanner.close();
    }
}

