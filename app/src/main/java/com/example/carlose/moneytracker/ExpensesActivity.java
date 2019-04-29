package com.example.carlose.moneytracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ExpensesActivity extends AppCompatActivity {
    private CardView expenseslist;
    private TextView expenseName;
    private TextView expenseAmount;
    private TextView expenseDueDate;
    private Button createExpense;
    private RecyclerView expensesCreateRView;
    MasterClass masterClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_expenses);

        this.expenseName = findViewById(R.id.expensesNameTxtBox);
        this.expenseAmount = findViewById(R.id.expensesAmountTxtBox);
        this.expenseDueDate = findViewById(R.id.dueDateExpensesTxtBox);
        this.createExpense = findViewById(R.id.createButtonExpense);
        this.expensesCreateRView = findViewById(R.id.expensesCreateRecyclerView);
        this.masterClass = MasterClass.get(this);

        expenseslist = (CardView) findViewById(R.id.expensesCardViewE);

        if (masterClass.getExpenses().size() > 0) {

            expenseslist.setVisibility(View.GONE);
            initRecyclerViewAccounts();
        } else {

            expensesCreateRView.setVisibility(View.GONE);
            expenseslist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(ExpensesActivity.this, "Nothing to show", Toast.LENGTH_SHORT).show();
                }
            });
        }

        this.createExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!expenseName.getText().toString().equals("") && !expenseAmount.getText().toString().equals("") && !expenseDueDate.getText().toString().equals("")){

                    Expenses expenses = new Expenses(expenseName.getText().toString(),Double.parseDouble(expenseAmount.getText().toString()), expenseDueDate.getText().toString());

                    masterClass.addData(expenses);
                    expenseslist.setVisibility(View.GONE);
                    expensesCreateRView.setVisibility(View.VISIBLE);

                    initRecyclerViewAccounts();
                    expenseName.setText("");
                    expenseName.setText("");
                    expenseDueDate.setText("");
                }
                else{
                    Toast.makeText(ExpensesActivity.this, "All Fields are required", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initRecyclerViewAccounts(){

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.expensesCreateRecyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapterExpenses adapter = new RecyclerViewAdapterExpenses(this, masterClass.getExpenses());
        recyclerView.setAdapter(adapter);

    }


}
