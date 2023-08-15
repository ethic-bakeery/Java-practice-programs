import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Transaction {
    String type;
    double amount;
}

class Account {
    int accountNumber;
    String customerName;
    double balance;
    List<Transaction> transactions;

    public Account(int accountNumber, String customerName) {
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Account> accounts = new ArrayList<>();
        int accountNumber = 1001;
        int choice;

        do {
            System.out.println("\nBanking System Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Account Information");
            System.out.println("5. View Transaction History");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();

                    Account newAccount = new Account(accountNumber, customerName);
                    accounts.add(newAccount);
                    System.out.println("Account created successfully. Account number: " + accountNumber);
                    accountNumber++;
                    break;
                }
                case 2: {
                    System.out.print("Enter account number: ");
                    int accountNum = scanner.nextInt();

                    Account account = findAccount(accounts, accountNum);
                    if (account == null) {
                        System.out.println("Account not found.");
                        break;
                    }

                    System.out.print("Enter amount to deposit: ");
                    double amount = scanner.nextDouble();
                    deposit(account, amount);
                    break;
                }
                case 3: {
                    System.out.print("Enter account number: ");
                    int accountNum = scanner.nextInt();

                    Account account = findAccount(accounts, accountNum);
                    if (account == null) {
                        System.out.println("Account not found.");
                        break;
                    }

                    System.out.print("Enter amount to withdraw: ");
                    double amount = scanner.nextDouble();
                    withdraw(account, amount);
                    break;
                }
                case 4: {
                    System.out.print("Enter account number: ");
                    int accountNum = scanner.nextInt();

                    Account account = findAccount(accounts, accountNum);
                    if (account == null) {
                        System.out.println("Account not found.");
                        break;
                    }

                    displayAccountInfo(account);
                    break;
                }
                case 5: {
                    System.out.print("Enter account number: ");
                    int accountNum = scanner.nextInt();

                    Account account = findAccount(accounts, accountNum);
                    if (account == null) {
                        System.out.println("Account not found.");
                        break;
                    }

                    displayTransactionHistory(account);
                    break;
                }
                case 6:
                    // Free memory for all accounts
                    for (Account account : accounts) {
                        account = null;
                    }
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);

        scanner.close();
    }

    private static Account findAccount(List<Account> accounts, int accountNumber) {
        for (Account account : accounts) {
            if (account.accountNumber == accountNumber) {
                return account;
            }
        }
        return null;
    }

    private static void deposit(Account account, double amount) {
        account.balance += amount;
        Transaction transaction = new Transaction();
        transaction.type = "Deposit";
        transaction.amount = amount;
        account.transactions.add(transaction);
        System.out.println("Amount deposited successfully.");
    }

    private static void withdraw(Account account, double amount) {
        if (account.balance >= amount) {
            account.balance -= amount;
            Transaction transaction = new Transaction();
            transaction.type = "Withdrawal";
            transaction.amount = amount;
            account.transactions.add(transaction);
            System.out.println("Amount withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private static void displayAccountInfo(Account account) {
        System.out.println("Account Number: " + account.accountNumber);
        System.out.println("Customer Name: " + account.customerName);
        System.out.println("Account Balance: " + account.balance);
    }

    private static void displayTransactionHistory(Account account) {
        System.out.println("Transaction History for Account Number " + account.accountNumber + ":");
        for (Transaction transaction : account.transactions) {
            System.out.println("Type: " + transaction.type + "\tAmount: " + transaction.amount);
        }
    }
}
