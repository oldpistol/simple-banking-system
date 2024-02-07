import java.util.Scanner;

import exceptions.IllegalArgumentException;
import exceptions.InsufficientFundsException;
import modules.Account;
import modules.BankManager;
import modules.Customer;
import modules.SavingsAccount;

public class MainBankSystem {
    public static void main(String[] args) {
        BankManager bankManager = new BankManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("==== Bank Management System ====");
            System.out.println("1. Create Customer");
            System.out.println("2. Create Account");
            System.out.println("3. Create Savings Account");
            System.out.println("4. Make Deposit");
            System.out.println("5. Make Withdrawal");
            System.out.println("6. View Account Balances");
            System.out.println("7. View Transactions");
            System.out.println("8. View Customers");
            System.out.println("9. View Accounts");
            System.out.println("10. View Saving Accounts");
            System.out.println("11. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    createCustomer(bankManager, scanner);
                    break;
                case 2:
                    createAccount(bankManager, scanner);
                    break;
                case 3:
                    createSavingsAccount(bankManager, scanner);
                    break;
                case 4:
                    makeDeposit(bankManager, scanner);
                    break;
                case 5:
                    makeWithdrawal(bankManager, scanner);
                    break;
                case 6:
                    viewAccountBalances(bankManager);
                    break;
                case 7:
                    viewTransactions(bankManager);
                    break;
                case 8:
                    viewCustomers(bankManager);
                    break;
                case 9:
                    viewAccounts(bankManager);
                    break;
                case 10:
                    viewSavingsAccounts(bankManager);
                    break;
                case 11:
                    System.out.println("Exiting the Bank Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 11.");
            }
        }
    }

    private static void createCustomer(BankManager bankManager, Scanner scanner) {
        System.out.println();
        System.out.println("==== Create Customer ====");
        System.out.print("Enter customer ID: ");
        String customerId = scanner.nextLine();
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer address: ");
        String address = scanner.nextLine();

        Customer customer = new Customer(customerId, name, address);
        bankManager.addCustomer(customer);
        System.out.println("Customer created successfully.");
    }

    private static void createAccount(BankManager bankManager, Scanner scanner) {
        System.out.println();
        System.out.print("Enter customer ID for the account: ");
        String customerId = scanner.nextLine();
        Customer customer = findCustomerById(bankManager, customerId);

        if (customer != null) {
            System.out.print("Enter initial balance for the account: ");
            double initialBalance = scanner.nextDouble();

            bankManager.createAccount(customer, initialBalance);
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static void createSavingsAccount(BankManager bankManager, Scanner scanner) {
        System.out.println();
        System.out.print("Enter customer ID for the account: ");
        String customerId = scanner.nextLine();
        Customer customer = findCustomerById(bankManager, customerId);

        if (customer != null) {
            System.out.print("Enter initial balance for the account: ");
            double initialBalance = scanner.nextDouble();
            System.out.print("Enter interest rate for the savings account: ");
            double interestRate = scanner.nextDouble();

            bankManager.createSavingsAccount(customer, initialBalance, interestRate);
            System.out.println("Savings account created successfully.");
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static void makeDeposit(BankManager bankManager, Scanner scanner) {
        System.out.println();
        System.out.print("Enter account ID for the deposit: ");
        String accountId = scanner.nextLine();
        Account account = findAccountById(bankManager, accountId);

        if (account != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();

            try {
                bankManager.makeDeposit(account, amount);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void makeWithdrawal(BankManager bankManager, Scanner scanner) {
        System.out.println();
        System.out.print("Enter account ID for the withdrawal: ");
        String accountId = scanner.nextLine();
        Account account = findAccountById(bankManager, accountId);

        if (account != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();

            try {
                bankManager.makeWithdrawal(account, amount);
            } catch (InsufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void viewAccountBalances(BankManager bankManager) {
        System.out.println();
        System.out.println("+------------+-------------------+---------------+");
        System.out.println("| Account ID |   Customer Name   |    Balance    |");
        System.out.println("+------------+-------------------+---------------+");
        for (Account account : bankManager.getAccounts()) {
            System.out.printf("| %-10s | %-17s | $%-11.2f |%n",
                    account.getAccountId(), account.getCustomer().getName(), account.getBalance());
        }
        System.out.println("+------------+-------------------+---------------+");
        System.out.println();
    }

    private static void viewTransactions(BankManager bankManager) {
        System.out.println();
        System.out.println("==== Transactions ====");
        bankManager.displayTransactions();
    }

    private static Customer findCustomerById(BankManager bankManager, String customerId) {
        for (Customer customer : bankManager.getCustomers()) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    private static Account findAccountById(BankManager bankManager, String accountId) {
        for (Account account : bankManager.getAccounts()) {
            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }
        return null;
    }

    private static void viewCustomers(BankManager bankManager) {
        System.out.println();
        System.out.println("+--------------+----------------------+-------------------------------+");
        System.out.println("| Customer ID  |        Name          |           Address             |");
        System.out.println("+--------------+----------------------+-------------------------------+");
        for (Customer customer : bankManager.getCustomers()) {
            System.out.println(String.format("| %-12s | %-20s | %-30s |",
                    customer.getCustomerId(), customer.getName(), customer.getAddress()));
        }
        System.out.println("+--------------+----------------------+-------------------------------+");
        System.out.println();
    }

    private static void viewAccounts(BankManager bankManager) {
        System.out.println();
        System.out.println("+------------+------------------+-------------+");
        System.out.println("| Account ID |     Customer     |   Balance   |");
        System.out.println("+------------+------------------+-------------+");
        for (Account account : bankManager.getAccounts()) {
            System.out.printf("| %-10s | %-16s | $%-9.2f |%n",
                    account.getAccountId(), account.getCustomer().getName(), account.getBalance());
        }
        System.out.println("+------------+------------------+-------------+");
        System.out.println();
    }

    private static void viewSavingsAccounts(BankManager bankManager) {
        System.out.println();
        System.out.println("+------------+------------------+-------------+-------------------+");
        System.out.println("| Account ID |     Customer     |   Balance   |  Interest Rate   |");
        System.out.println("+------------+------------------+-------------+-------------------+");
        for (Account account : bankManager.getAccounts()) {
            if (account instanceof SavingsAccount) {
                SavingsAccount savingsAccount = (SavingsAccount) account;
                System.out.printf("| %-10s | %-16s | $%-9.2f | %-17s |%n",
                        savingsAccount.getAccountId(), savingsAccount.getCustomer().getName(),
                        savingsAccount.getBalance(), savingsAccount.getInterestRate());
            }
        }
        System.out.println("+------------+------------------+-------------+-------------------+");
        System.out.println();
    }

}
