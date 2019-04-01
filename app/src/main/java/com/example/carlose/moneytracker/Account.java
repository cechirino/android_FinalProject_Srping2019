package com.example.carlose.moneytracker;

public class Account {
    private int amountID;
    private String accountName;
    private String type;
    private double amount;

    public Account(String accountName, String type, double amount) {
        this.accountName = accountName;
        this.type = type;
        this.amount = amount;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
