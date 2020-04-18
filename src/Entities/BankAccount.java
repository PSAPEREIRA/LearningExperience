package Entities;

public class BankAccount {

    private int accountNumber;
    private String nameAccountHolder;
    private double balance;

    public BankAccount(int accountNumber, String nameAccountHolder) {
        this.accountNumber = accountNumber;
        this.nameAccountHolder = nameAccountHolder;
    }

    public BankAccount(int accountNumber, String nameAccountHolder, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.nameAccountHolder = nameAccountHolder;
        deposit(initialDeposit);
    }


    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
    public String getNameAccountHolder() {
        return nameAccountHolder;
    }

    public void setNameAccountHolder(String nameAccountHolder) {
        this.nameAccountHolder = nameAccountHolder;
    }

    public void deposit(double value) {
        this.balance += value;
    }

    public void withdraw(double value) {
        this.balance -= value + 5.0;
    }



    public String toString() {
        return "Account: " + accountNumber + ", Holder: " + nameAccountHolder + ", Balance: " + String.format("%.2f €", balance);
    }
}
