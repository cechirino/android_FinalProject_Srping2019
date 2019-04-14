package com.example.carlose.moneytracker;

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

import java.io.FileOutputStream;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private Button menu;
    private CardView expensesCardView;
    private static ArrayList<Budget> budgetsList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu = (Button) findViewById(R.id.menuButton);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallActivity();
            }
        });

        expensesCardView = (CardView) findViewById(R.id.expensesCardView);

        expensesCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallExpensesEditLayout();
            }
        });

        addInfo();
        if (budgetsList.size() > 0) {
            // CardView cardView = findViewById(R.id.budgetCardViewEmpty);
            // cardView.setVisibility(View.GONE);
            addInfo();
            initRecyclerViewBudgets();
        } else {
            RecyclerView viewRecyclerView = findViewById(R.id.budgetRecyclerView);
            viewRecyclerView.setVisibility(View.GONE);
        }

    }

    private void addInfo() {

        for (int i = 0; i < 10; i++) {
            Budget budget = new Budget("Hola" + i, 2 + 1, 3 + i);

            budgetsList.add(budget);
        }

    }

    //Add the data to the Budgets List
    private void initRecyclerViewBudgets() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.budgetRecyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, budgetsList);
        recyclerView.setAdapter(adapter);
    }

    private void CallExpensesEditLayout() {
        Intent intent = new Intent(getApplicationContext(), EditExpensesActivity.class);
        startActivity(intent);
    }

    private void CallActivity() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
