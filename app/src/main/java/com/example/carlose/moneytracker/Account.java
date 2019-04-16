package com.example.carlose.moneytracker;

public class Account {
    private Integer accountID;
    private String accountName;
    private String type;
    private Double amount;

    public Account(int accountID, String accountName, String type, double amount) {
        this.accountID = accountID;
        this.accountName = accountName;
        this.type = type;
        this.amount = amount;
    }

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

    public Double getAmount() {
        return amount;
    }

    public String getAmountString() {
        return amount.toString();
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getAccountID() {
        return accountID;
    }

    public String getAccountIDString() {
        return accountID.toString();
    }
}
