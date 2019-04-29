package com.example.carlose.moneytracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EditExpensesActivity extends AppCompatActivity {

    private TextView expendingMoney;
    private TextView expenseNamelabel;
    private TextView expenseNewName;
    private TextView expenseAmount;
    private TextView dueDateExpense;
    private MasterClass masterClass;
    private Button removeExpense;
    private Button saveExpense;
    private Expenses expenses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_edit_expenses);

        this.expendingMoney = findViewById(R.id.moneytoSpendEdit);
        this.expenseNamelabel = findViewById(R.id.nameExpenseLabelEdit);
        this.expenseNewName = findViewById(R.id.nameExpensesTxtBoxEdit);
        this.expenseAmount = findViewById(R.id.expensesAmounttxtBoxEdit);
        this.dueDateExpense = findViewById(R.id.dueDateExpensesTxtBoxEdit);
        this.removeExpense = findViewById(R.id.removeButtonExpenses);
        this.saveExpense = findViewById(R.id.saveButtonExpenses);
        this.masterClass = MasterClass.get(this);

        this.expenses = (Expenses) getIntent().getSerializableExtra("Expenses");

        this.expendingMoney.setText("-$" + expenses.getAmountString());
        this.expenseNamelabel.setText(expenses.getExpenseName());
        this.expenseNewName.setText(expenses.getExpenseName());
        this.expenseAmount.setText(expenses.getAmountString());
        this.dueDateExpense.setText(expenses.getDueDate());

        this.removeExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeExpense();
            }
        });

        this.saveExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveExpense();
            }
        });

    }

    private void removeExpense(){
        this.masterClass.delete(expenses);

        Intent intent = new Intent(this, ExpensesActivity.class);
        startActivity(intent);
    }

    private void saveExpense(){
        if(!expenseNewName.getText().toString().equals("") && !expenseAmount.getText().toString().equals("") && !dueDateExpense.getText().toString().equals("")){
            this.expenses.setExpenseName(this.expenseNewName.getText().toString());
            this.expenses.setAmount(Double.parseDouble(this.expenseAmount.getText().toString()));
            this.expenses.setDueDate(this.dueDateExpense.getText().toString());

            this.masterClass.update(expenses);

            Intent intent = new Intent(this, EditExpensesActivity.class);
            startActivity(intent);

        }
        else{
            Toast.makeText(EditExpensesActivity.this, "All Fields are required", Toast.LENGTH_SHORT).show();
        }
    }


}
