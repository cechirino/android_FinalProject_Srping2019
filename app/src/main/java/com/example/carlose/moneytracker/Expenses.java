package com.example.carlose.moneytracker;

public class Expenses {
    private int expensesID;
    private String expenseName;
    private double amount;
    String dueDate;
    int account;

    public Expenses(int expensesID, String expenseName, double amount, String dueDate) {
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

    public double getAmount() {
        return amount;
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
}
