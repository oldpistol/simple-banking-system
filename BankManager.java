import java.util.ArrayList;

class BankManager {
    private ArrayList<Customer> customers;
    private ArrayList<Account> accounts;
    private TransactionManager transactionManager;

    public BankManager() {
        this.customers = new ArrayList<>();
        this.accounts = new ArrayList<>();
        this.transactionManager = new TransactionManager();
    }

    public ArrayList<Account> getAccounts() {
        return this.accounts;
    }

    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
        System.out.println("Customer added: " + customer.getName());
    }

    public void createAccount(Customer customer, double initialBalance) {
        String accountId = "ACC" + (accounts.size() + 1); // Simple account ID generation
        Account account = new Account(accountId, customer, initialBalance);
        this.accounts.add(account);
        System.out.println("Account created for customer " + customer.getName() + ". Account ID: " + accountId);
    }

    public void createSavingsAccount(Customer customer, double initialBalance, double interestRate) {
        String accountId = "SAV" + (accounts.size() + 1); // Simple savings account ID generation
        SavingsAccount savingsAccount = new SavingsAccount(accountId, customer, initialBalance, interestRate);
        this.accounts.add(savingsAccount);
        System.out.println("Savings account created for customer " + customer.getName() + ". Account ID: " + accountId);
    }

    public void makeDeposit(Account account, double amount) throws IllegalArgumentException {
        if (account != null) {
            DepositTransaction depositTransaction = new DepositTransaction(
                    "DEP" + (transactionManager.getTransactions().size() + 1), "Deposit", amount,
                    account.getAccountId());
            try {
                account.deposit(amount);
                transactionManager.recordTransaction(depositTransaction);
                System.out.println(
                        "Deposit transaction recorded. Transaction ID: " + depositTransaction.getTransactionId());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Error: Account not found.");
        }
    }

    public void makeWithdrawal(Account account, double amount) throws InsufficientFundsException {
        if (account != null) {
            WithdrawalTransaction withdrawalTransaction = new WithdrawalTransaction("WTH" + (accounts.size() + 1),
                    "Withdrawal", amount, account.getAccountId());
            try {
                account.withdraw(amount);
                transactionManager.recordTransaction(withdrawalTransaction);
                System.out.println(
                        "Withdrawal transaction recorded. Transaction ID: " + withdrawalTransaction.getTransactionId());
            } catch (InsufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Error: Account is null.");
        }
    }

    public void displayTransactions() {
        transactionManager.displayTransactions();
    }

}
