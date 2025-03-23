package Day9;
import java.util.*;
class Account {
    int accountNumber;
    double balance;
    public Account(int accountNumber, double initialAmount) {
        this.accountNumber = accountNumber;
        this.balance = initialAmount;
    }
    public double getBalance() {
        return balance;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
}
class Customer {
     String name;
     List<Account> accounts;
    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }
    public void addAccount(Account account) {
        accounts.add(account);
    }
    public void viewBalance() {
        System.out.println("Customer: " + name);
        for (Account account : accounts) {
            System.out.println("Account #" + account.getAccountNumber() + " - Balance: $" + account.getBalance());
        }
    }
    public String getName() {
        return name;
    }
}
class Bank {
     String bankName;
     List<Customer> customers;
    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }
    public void openAccount(Customer customer, int accountNumber, double
            initialDeposit) {
        Account newAccount = new Account(accountNumber, initialDeposit);
        customer.addAccount(newAccount);
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        System.out.println("Bank: " + bankName + " opened account #" +
                accountNumber + " for " + customer.getName());
    }
}
public class BankingSystem {
    public static void main(String[] args) {
        Bank bank = new Bank("ICICI Bank");
        Customer ramesh = new Customer("Ramesh");
        Customer suresh = new Customer("Suresh");
        bank.openAccount(ramesh, 1001, 5000.00);
        bank.openAccount(ramesh, 1002, 2000.00);
        bank.openAccount(suresh, 2001, 3000.00);
        System.out.println();
        ramesh.viewBalance();
        System.out.println();
        suresh.viewBalance();
    }
}