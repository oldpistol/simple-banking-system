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
        System.out.println();
        System.out.println("+-----------------+-------------------------------+-------------+");
        System.out.println("| Transaction ID  |          Description          |   Amount    |");
        System.out.println("+-----------------+-------------------------------+-------------+");
        for (Transaction transaction : transactions) {
            System.out.printf("| %-15s | %-29s | $%-9.2f |%n",
                    transaction.getTransactionId(), transaction.getDescription(), transaction.getAmount());
        }
        System.out.println("+-----------------+-------------------------------+-------------+");
        System.out.println();
    }

}
