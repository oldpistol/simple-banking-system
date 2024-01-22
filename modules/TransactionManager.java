package modules;

import java.util.ArrayList;

class TransactionManager {
    private ArrayList<Transaction> transactions;

    public TransactionManager() {
        this.transactions = new ArrayList<>();
    }

    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

    public void recordTransaction(Transaction transaction) {
        this.transactions.add(transaction);
        System.out.println("Transaction recorded. Transaction ID: " + transaction.getTransactionId());
    }

    public void displayTransactions() {
        System.out.println("Transactions in the system:");
        for (Transaction transaction : transactions) {
            System.out.println("Transaction ID: " + transaction.getTransactionId() +
                    ", Description: " + transaction.getDescription() +
                    ", Amount: $" + transaction.getAmount());
        }
    }
}
