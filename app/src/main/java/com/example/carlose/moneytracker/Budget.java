package com.example.carlose.moneytracker;

public class Budget {
    private double goal;
    private double amount;
    int account;

    public Budget(double goal, double amount, int account) {
        this.goal = goal;
        this.amount = amount;
        this.account = account;
    }

    public double getGoal() {
        return goal;
    }

    public void setGoal(double goal) {
        this.goal = goal;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }
}
