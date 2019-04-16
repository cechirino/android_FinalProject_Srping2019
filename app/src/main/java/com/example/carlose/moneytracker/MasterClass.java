package com.example.carlose.moneytracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import database.monayTrackerCursorWrapper;
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
        values.put(expensesTable.Cols.expensesName, expenses.getExpenseName());
        values.put(expensesTable.Cols.amountExpense, expenses.getAmount());
        values.put(expensesTable.Cols.dueDate, expenses.getDueDate());

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

        mDataBase.insert(accountTable.Name, null, values);
    }

    //Add data to the budget table
    public void addData(Expenses e){
        ContentValues values = getContentValues(e);

        mDataBase.insert(expensesTable.Name, null, values);
    }

    //Add the code in the final stage of the app

    //Update Budget Info
    public void update(Budget b){
        String budgetID =  b.getBudgetIDString();
        ContentValues contentValues = getContentValues(b);

        mDataBase.update(budgetTable.Name, contentValues, budgetTable.Cols.budgetID + "= ?", new String[]{budgetID});
    }

    //Update Account Info
    public void update(Account a){
        String accountID =  a.getAccountIDString();
        ContentValues contentValues = getContentValues(a);

        mDataBase.update(accountTable.Name, contentValues, accountTable.Cols.accountID + "= ?", new String[]{accountID});
    }

    //Update Expenses Info
    public  void update(Expenses e){
        String expenseID =  e.getExpensesIDString();
        ContentValues contentValues = getContentValues(e);

        mDataBase.update(expensesTable.Name, contentValues, expensesTable.Cols.expensesID + "= ?", new String[]{expenseID});
    }

    //Insert Budget Info
    public void insertData(Budget b){
        ContentValues values = getContentValues(b);
        mDataBase.insert(budgetTable.Name, null, values);
    }

    //Insert Account Info
    public void insertData(Account a){
        ContentValues values = getContentValues(a);
        mDataBase.insert(accountTable.Name, null, values);
    }

    //Insert Expenses Info
    public  void insertData(Expenses e){
        ContentValues values = getContentValues(e);
        mDataBase.insert(expensesTable.Name, null, values);
    }

    //Delete Budget
    public void delete(Budget b){}

    //Delete Account
    public void delete(Account a){}

    //Delete Expenses
    public  void delete(Expenses e){}

    //return a list with all the budget stored in the database
    public List<Budget> getBudgets(){
        List<Budget> budgets = new ArrayList<>();

        monayTrackerCursorWrapper cursorWrapper = budgetQuery(null,null);

        try{
            cursorWrapper.moveToFirst();
            while (!cursorWrapper.isAfterLast()){
                budgets.add(cursorWrapper.getBudget());
                cursorWrapper.moveToNext();
            }
        }
        catch (Exception e){
            Toast.makeText(context.getApplicationContext(),"Some has gone wrong :(" + e.toString(), Toast.LENGTH_SHORT);
        }
        finally {
            cursorWrapper.close();
        }
        return budgets;
    }

    //return a list with all the expenses stored in the database
    public List<Expenses> getExpenses(){
        List<Expenses> expenses = new ArrayList<>();

        monayTrackerCursorWrapper cursorWrapper = expensesQuery(null,null);

        try{
            cursorWrapper.moveToFirst();
            while (!cursorWrapper.isAfterLast()){
                expenses.add(cursorWrapper.getExpense());
                cursorWrapper.moveToNext();
            }
        }
        catch (Exception e){
            Toast.makeText(context.getApplicationContext(),"Some has gone wrong :(" + e.toString(), Toast.LENGTH_SHORT);
        }
        finally {
            cursorWrapper.close();
        }
        return expenses;
    }

    //return a list with all the accounts stored in the database
    public List<Account> getAccount(){
        List<Account> accounts = new ArrayList<>();

        monayTrackerCursorWrapper cursorWrapper = accountsQuery(null,null);

        try{
            cursorWrapper.moveToFirst();
            while (!cursorWrapper.isAfterLast()){
                accounts.add(cursorWrapper.getAccount());
                cursorWrapper.moveToNext();
            }
        }
        catch (Exception e){
            Toast.makeText(context.getApplicationContext(),"Some has gone wrong :(" + e.toString(), Toast.LENGTH_SHORT);
        }
        finally {
            cursorWrapper.close();
        }
        return accounts;
    }



    private monayTrackerCursorWrapper budgetQuery(String whereClause, String[] whereArgs){
        Cursor cursor = mDataBase.query(budgetTable.Name,null, whereClause, whereArgs,null, null,null);
        return  new monayTrackerCursorWrapper(cursor);
    }

    private monayTrackerCursorWrapper expensesQuery(String whereClause, String[] whereArgs){
        Cursor cursor = mDataBase.query(expensesTable.Name,null, whereClause, whereArgs,null, null,null);
        return  new monayTrackerCursorWrapper(cursor);
    }

    private monayTrackerCursorWrapper accountsQuery(String whereClause, String[] whereArgs){
        Cursor cursor = mDataBase.query(accountTable.Name,null, whereClause, whereArgs,null, null,null);
        return  new monayTrackerCursorWrapper(cursor);
    }


}
