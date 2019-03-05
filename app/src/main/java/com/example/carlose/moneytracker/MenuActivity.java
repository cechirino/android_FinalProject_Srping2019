package com.example.carlose.moneytracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {
    private Button homeButton;
    private Button accountsButton;
    private Button budgetButton;
    private Button receiptsButton;
    private Button expensesButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        homeButton = (Button) findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallHome();
            }
        });

        accountsButton = (Button) findViewById(R.id.accountButtonMenu);
        accountsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallAccountActivity();
            }
        });

        budgetButton = (Button) findViewById(R.id.budgetButtoMenu);
        budgetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallBudgetActivity();
            }
        });

        receiptsButton = (Button) findViewById(R.id.receiptsButtonmenu);
        receiptsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallReceiptActivity();
            }
        });

        expensesButton = (Button) findViewById(R.id.expensesButtonMenu);
        expensesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallExpensestActivity();
            }
        });

    }

    private void CallHome(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void CallAccountActivity(){
        Intent intent = new Intent(this, AccountActivity.class);
        startActivity(intent);
    }

    private void CallBudgetActivity(){
        Intent intent = new Intent(this, BudgetActivity.class);
        startActivity(intent);
    }

    private void CallReceiptActivity(){
        Intent intent = new Intent(this, ReceiptActivity.class);
        startActivity(intent);
    }

    private void CallExpensestActivity(){
        Intent intent = new Intent(this, ExpensesActivity.class);
        startActivity(intent);
    }
}
