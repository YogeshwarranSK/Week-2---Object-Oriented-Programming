package Day6.Level2;
class bankAccount {
    public static class BankAccount {
        private final String accountHolder;
        private final String accountNumber;
        private double balance;

        public BankAccount(String accountHolder, String accountNumber, double balance) {
            this.accountHolder = accountHolder;
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited $" + amount + ". New balance: $" + balance);
            } else {
                System.out.println("Deposit amount must be positive.");
            }
        }

        public void withdraw(double amount) {
            if (amount > 0) {
                if (balance >= amount) {
                    balance -= amount;
                    System.out.println("Withdrawn $" + amount + ". New balance: $" + balance);
                } else {
                    System.out.println("Insufficient balance.");
                }
            } else {
                System.out.println("Withdrawal amount must be positive.");
            }
        }

        public void displayBalance() {
            System.out.println("Account Holder: " + accountHolder);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Current Balance: $" + balance);
        }
    }
}
public class BankAccount {
    public static void main(String[] args) {
        bankAccount.BankAccount account = new bankAccount.BankAccount("Ranbir", "100030024058589", 100000.0);
        account.displayBalance();
        account.deposit(100000);
        account.withdraw(2000);
        account.withdraw(3000);
    }
}

