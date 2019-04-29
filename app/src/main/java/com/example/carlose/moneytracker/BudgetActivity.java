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

public class BudgetActivity extends AppCompatActivity {

    private  CardView budgetList;
    private TextView nameBudget;
    private TextView amountBudget;
    private TextView goalBudget;
    private Button createButton;
    private RecyclerView viewRecyclerView;

    MasterClass masterClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_budget);

        this.nameBudget = findViewById(R.id.nameBudgetTxtBox);
        this.amountBudget = findViewById(R.id.amountBudgetTxtBox);
        this.goalBudget = findViewById(R.id.goalBudgetTxtBox);
        this.createButton =findViewById(R.id.createButtonBudget);

        masterClass = MasterClass.get(this);

        budgetList = (CardView) findViewById(R.id.editBudgetCardViewB);
        viewRecyclerView = findViewById(R.id.budgetCreateRecyclerView);

        if (masterClass.getBudgets().size() > 0) {

            budgetList.setVisibility(View.GONE);
            initRecyclerViewAccounts();
        } else {

            viewRecyclerView.setVisibility(View.GONE);
            budgetList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(BudgetActivity.this, "Nothing to show", Toast.LENGTH_SHORT).show();
                }
            });
        }

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!nameBudget.getText().toString().equals("") && !amountBudget.getText().toString().equals("") && !goalBudget.getText().toString().equals("")){

                    Budget budget = new Budget(nameBudget.getText().toString(),Double.parseDouble(goalBudget.getText().toString())
                            , Double.parseDouble(amountBudget.getText().toString()));

                    masterClass.addData(budget);
                    budgetList.setVisibility(View.GONE);
                    viewRecyclerView.setVisibility(View.VISIBLE);

                    initRecyclerViewAccounts();
                    nameBudget.setText("");
                    goalBudget.setText("");
                    amountBudget.setText("");
                }
                else{
                    Toast.makeText(BudgetActivity.this, "All Fields are required", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initRecyclerViewAccounts(){

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.budgetCreateRecyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, masterClass.getBudgets());
        recyclerView.setAdapter(adapter);

    }

    @Override
    public  void onBackPressed(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

}
