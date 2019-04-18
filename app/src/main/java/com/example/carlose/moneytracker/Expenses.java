package com.example.carlose.moneytracker;

import java.io.Serializable;

public class Expenses implements Serializable {
    private Integer expensesID;
    private String expenseName;
    private Double amount;
    String dueDate;
    int account;

    public Expenses(int expensesID, String expenseName, double amount, String dueDate) {
        this.expensesID = expensesID;
        this.expenseName = expenseName;
        this.amount = amount;
        this.dueDate = dueDate;
        this.account = account;
    }

    public Expenses(String expenseName, double amount, String dueDate) {
        this.expenseName = expenseName;
        this.amount = amount;
        this.dueDate = dueDate;
        this.account = account;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public Double getAmount() {
        return amount;
    }

    public String getAmountString() {
        return amount.toString();
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public Integer getExpensesID() {
        return expensesID;
    }

    public String getExpensesIDString() {
        return expensesID.toString();
    }
}
