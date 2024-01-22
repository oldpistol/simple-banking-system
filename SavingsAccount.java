class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountId, Customer customer, double initialBalance, double interestRate) {
        super(accountId, customer, initialBalance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void deposit(double amount) throws IllegalArgumentException {
        super.deposit(amount);
        // Additional logic for calculating interest
        System.out.println("Interest calculated for savings account.");
    }
}