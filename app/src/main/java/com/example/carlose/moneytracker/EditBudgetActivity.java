package com.example.carlose.moneytracker;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EditBudgetActivity extends AppCompatActivity {

    private TextView nameBudgetEdit;
    private TextView amountBudgetEdit;
    private TextView goalBudgetEdit;
    private Button removeBudget;
    private Button saveBudget;
    private MasterClass masterClass;
    private Budget budget;
    private TextView moneySave;
    private TextView budgetNameLabel;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_edit_budget);

        this.nameBudgetEdit = findViewById(R.id.nameBudgetEditTxtBox);
        this.amountBudgetEdit = findViewById(R.id.amountBudgetEditTxtBox);
        this.goalBudgetEdit = findViewById(R.id.goalBudgetEditTxtBox);
        this.removeBudget = findViewById(R.id.removeButtonBudget);
        this.saveBudget = findViewById(R.id.saveButtonBudget);
        this.moneySave = findViewById(R.id.moneySavedBudgetEdit);
        this.budgetNameLabel = findViewById(R.id.nameBudgetLabelEdit);
        this.masterClass = MasterClass.get(this);

        this.budget = (Budget) getIntent().getSerializableExtra("Budget");

        this.nameBudgetEdit.setText(budget.getBudgetName());
        this.amountBudgetEdit.setText(budget.getAmountString());
        this.goalBudgetEdit.setText(budget.getGoalString());
        this.moneySave.setText(budget.getAmountString());
        this.budgetNameLabel.setText(budget.getBudgetName());

        this.removeBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeBudget();
            }
        });

        this.saveBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveBudget();
            }
        });
    }

    private void removeBudget(){
        this.masterClass.delete(budget);

        Intent intent = new Intent(this, BudgetActivity.class);
        startActivity(intent);
    }

    private void saveBudget(){
        if(!this.nameBudgetEdit.getText().toString().equals("") && !this.amountBudgetEdit.getText().toString().equals("") && !this.goalBudgetEdit.getText().toString().equals("")){

            this.budget.setBudgetName(this.nameBudgetEdit.getText().toString());
            this.budget.setAmount(Double.parseDouble(this.amountBudgetEdit.getText().toString()));
            this.budget.setGoal(Double.parseDouble(this.goalBudgetEdit.getText().toString()));
            this.masterClass.update(this.budget);

            Intent intent = new Intent(this, BudgetActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(EditBudgetActivity.this, "All Fields are required", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public  void onBackPressed(){
        Intent intent = new Intent(this, BudgetActivity.class);
        startActivity(intent);
    }
}
