package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import database.moneytrackerDbSchema.accountTable;
import database.moneytrackerDbSchema.budgetTable;
import database.moneytrackerDbSchema.expemsesTabel;


public class moneyTrackerBaseHelper extends SQLiteOpenHelper {

    private static final int Version = 1;
    private static final String DATABASE_NAME = "moneyTrackerBase.db";

    public moneyTrackerBaseHelper(Context context){
        super(context, DATABASE_NAME, null, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + budgetTable.Name + "(" + budgetTable.Cols.budgetID + " integer primary key autoincrement, " + budgetTable.Cols.budgetName + ", "
                + budgetTable.Cols.amountBudget + ", " + budgetTable.Cols.goal);

        db.execSQL(" CREATE TABLE " + accountTable.Name + "(" + accountTable.Cols.accountID + " integer primary key autoincrement, " + accountTable.Cols.accountName + ", "
                + accountTable.Cols.amountAccount + ", " + accountTable.Cols.type);

        db.execSQL(" CREATE TABLE " + expemsesTabel.Name + "(" + expemsesTabel.Cols.expensesID + " integer primary key autoincrement, " + expemsesTabel.Cols.expensesName + ", "
                + expemsesTabel.Cols.amountExpense + ", " + expemsesTabel.Cols.dueDate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
