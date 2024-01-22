package modules;

class DepositTransaction extends Transaction {
    private String accountId;

    public DepositTransaction(String transactionId, String description, double amount, String accountId) {
        super(transactionId, description, amount);
        this.accountId = accountId;
    }
}
