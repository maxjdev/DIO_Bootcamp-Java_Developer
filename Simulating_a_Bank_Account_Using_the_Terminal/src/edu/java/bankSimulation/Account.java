package edu.java.bankSimulation;

public class Account {
    private final Integer accountNumber;
    private final String agencyNumber;
    private final String clientName;
    private Double balanceAccount = 25.0;

    public Account(int accountNumber, String agencyNumber, String clientName) {
        this.accountNumber = accountNumber;
        this.agencyNumber = agencyNumber;
        this.clientName = clientName;
        System.out.println("\nHello " + getClientName() + ", thank you for creating an account with our bank, your branch is " + getAgencyNumber() + ", account " + getAccountNumber() + " and your balance " + getBalanceAccount() + " is now available for withdrawal");
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public String getAgencyNumber() {
        return agencyNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public Double getBalanceAccount() {
        return balanceAccount;
    }

    public void toWithdraw(double value) {
        if (value > 0 && value <= this.balanceAccount) {
            this.balanceAccount -= value;
            System.out.println("your new balance is: R$ " + this.balanceAccount);
        } else {
            System.out.println("Insufficient funds! your balance is: R$ " + this.balanceAccount);
        }
    }
}
