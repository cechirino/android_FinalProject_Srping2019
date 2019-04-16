package com.example.carlose.moneytracker;

import java.io.Serializable;

public class Budget implements Serializable {
    private Integer budgetID;
    private  String budgetName;
    private  Double goal;
    private  Double amount;
    private  int account;

    //Temporary constructor for tests
    public Budget(String budgetname, double goal, double amount) {
        this.budgetName = budgetname;
        this.goal = goal;
        this.amount = amount;
        this.account = account;
    }

    public Budget(int budgetID, String budgetname, double goal, double amount) {
        this.budgetName = budgetname;
        this.goal = goal;
        this.amount = amount;
        this.account = account;
    }

    public Double getGoal() {
        return goal;
    }

    public String getGoalString() {
        return goal.toString();
    }
    public void setGoal(double goal) {
        this.goal = goal;
    }

    public String getAmountString() {
        return amount.toString();
    }

    public Double getAmount(){
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

    public String getBudgetName() {
        return budgetName;
    }

    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

    public Integer getBudgetID() {
        return budgetID;
    }

    public String getBudgetIDString() {
        return budgetID.toString();
    }
}
