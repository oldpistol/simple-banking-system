package modules;

class WithdrawalTransaction extends Transaction {
    private String accountId;

    public WithdrawalTransaction(String transactionId, String description, double amount, String accountId) {
        super(transactionId, description, amount);
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }
}
