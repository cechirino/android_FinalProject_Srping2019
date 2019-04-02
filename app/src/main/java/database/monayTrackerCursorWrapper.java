package database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.carlose.moneytracker.Account;
import com.example.carlose.moneytracker.Budget;
import com.example.carlose.moneytracker.Expenses;

import database.moneytrackerDbSchema.accountTable;
import database.moneytrackerDbSchema.budgetTable;
import database.moneytrackerDbSchema.expemsesTabel;

public class monayTrackerCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public monayTrackerCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Budget getBudget(){
        int budgetID = getInt(getColumnIndex(budgetTable.Cols.budgetID));
        String budgetName = getString(getColumnIndex(budgetTable.Cols.budgetName));
        Double amount = getDouble(getColumnIndex(budgetTable.Cols.amountBudget));
        Double goal = getDouble(getColumnIndex(budgetTable.Cols.goal));

        Budget budget = new Budget(budgetID,budgetName, goal,amount);
        return budget;
    }

    public Expenses getExpense(){
        int expensesID = getInt(getColumnIndex(expemsesTabel.Cols.expensesID));
        String expenseName = getString(getColumnIndex(expemsesTabel.Cols.expensesName));
        Double amount = getDouble(getColumnIndex(expemsesTabel.Cols.amountExpense));
        String dueDate = getString(getColumnIndex(expemsesTabel.Cols.dueDate));

        Expenses expenses = new Expenses(expensesID, expenseName, amount,dueDate);
        return expenses;
    }

    public Account getAccount(){
        int acccountID = getInt(getColumnIndex(accountTable.Cols.accountID));
        String accountName = getString(getColumnIndex(accountTable.Cols.accountName));
        Double amount = getDouble(getColumnIndex(accountTable.Cols.amountAccount));
        String type = getString(getColumnIndex(accountTable.Cols.type));

        Account account = new Account(acccountID, accountName, type,  amount);

        return account;
    }
}
