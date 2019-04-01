package com.example.carlose.moneytracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import database.moneyTrackerBaseHelper;
import database.moneytrackerDbSchema;

import static database.moneytrackerDbSchema.*;


public class MasterClass {

    private Context context;
    private SQLiteDatabase mDataBase;

    public static MasterClass sMasterClass;

    public static MasterClass get(Context context){
        if(sMasterClass == null){
            sMasterClass = new MasterClass(context);
        }

        return sMasterClass;
    }

    private MasterClass(Context context){
        context = context.getApplicationContext();
        mDataBase = new moneyTrackerBaseHelper(context).getWritableDatabase();
    }

    private static ContentValues getContentValues(Budget budget){
        ContentValues values = new ContentValues();
        values.put(budgetTable.Cols.budgetName, budget.getBudgetName());
        values.put(budgetTable.Cols.amountBudget, budget.getAmount());
        values.put(budgetTable.Cols.goal, budget.getGoal());

        return values;
    }

    private static ContentValues getContentValues(Account account){
        ContentValues values = new ContentValues();
        values.put(accountTable.Cols.accountName, account.getAccountName());
        values.put(accountTable.Cols.amountAccount, account.getAmount());
        values.put(accountTable.Cols.type, account.getType());

        return values;
    }

    private static ContentValues getContentValues(Expenses  expenses){
        ContentValues values = new ContentValues();
        values.put(expemsesTabel.Cols.expensesName, expenses.getExpenseName());
        values.put(expemsesTabel.Cols.amountExpense, expenses.getAmount());
        values.put(expemsesTabel.Cols.dueDate, expenses.getDueDate());

        return values;
    }

    //Add data to the budget table
    public void addData(Budget b){
        ContentValues values = getContentValues(b);

        mDataBase.insert(budgetTable.Name, null, values);
    }

    //Add data to the budget table
    public void addData(Account a){
        ContentValues values = getContentValues(a);

        mDataBase.insert(budgetTable.Name, null, values);
    }

    //Add data to the budget table
    public void addData(Expenses e){
        ContentValues values = getContentValues(e);

        mDataBase.insert(budgetTable.Name, null, values);
    }

    public void update(Budget b){}


    public void update(Account a){}


    public  void update(Expenses e){}
}
