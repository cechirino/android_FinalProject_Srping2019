package com.example.carlose.moneytracker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private Button menu;
    private CardView expensesCardView;
    MasterClass masterClass;
    private static ArrayList<Budget> budgetsList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       masterClass =MasterClass.get(MainActivity.this);
        menu = (Button) findViewById(R.id.menuButton);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallActivity();
            }
        });

        expensesCardView = (CardView) findViewById(R.id.expensesCardViewEmpty);

        CardView cardViewBudgets = findViewById(R.id.budgetCardViewEmpty);

        if (masterClass.getBudgets().size() > 0) {

            cardViewBudgets.setVisibility(View.GONE);
            initRecyclerViewBudgets();
        } else {
            RecyclerView viewRecyclerView = findViewById(R.id.budgetRecyclerView);
            viewRecyclerView.setVisibility(View.GONE);
            cardViewBudgets.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Nothing to show", Toast.LENGTH_SHORT).show();
                }
            });
        }


        if (masterClass.getExpenses().size() > 0) {

            expensesCardView.setVisibility(View.GONE);
            initRecyclerViewExpense();
        } else {
            RecyclerView viewRecyclerView = findViewById(R.id.expensesRecyclerView);
            viewRecyclerView.setVisibility(View.GONE);
            expensesCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Nothing to show", Toast.LENGTH_SHORT).show();
                }
            });
        }


    }


    //Add the data to the Budgets List
    private void initRecyclerViewBudgets() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.budgetRecyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, masterClass.getBudgets());
        recyclerView.setAdapter(adapter);

    }

    //Add the data to the Expenses List
    private void initRecyclerViewExpense(){

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.expensesRecyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapterExpenses adapter = new RecyclerViewAdapterExpenses(this, masterClass.getExpenses());
        recyclerView.setAdapter(adapter);

    }



    private void CallActivity() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
