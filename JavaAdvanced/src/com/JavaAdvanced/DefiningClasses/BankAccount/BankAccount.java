package com.JavaAdvanced.DefiningClasses.BankAccount;

public class BankAccount {
    private static double interestRate = 0.02;
    private static int accountsCount = 1;
    private int id;
    private double balance;

    public BankAccount() {
        this.id = accountsCount;
        accountsCount++;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterest(int years) {
        return this.balance * interestRate * years;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getId() {
        return id;
    }
}
