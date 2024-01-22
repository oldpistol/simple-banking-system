class Transaction {
    private String transactionId;
    private String description;
    private double amount;

    public Transaction(String transactionId, String description, double amount) {
        this.transactionId = transactionId;
        this.description = description;
        this.amount = amount;
    }

    // Getters
    public String getTransactionId() {
        return transactionId;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    // Setters
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
