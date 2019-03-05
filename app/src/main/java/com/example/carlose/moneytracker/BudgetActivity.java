package com.example.carlose.moneytracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class BudgetActivity extends AppCompatActivity {

    private CardView budgetList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_budget);

        budgetList = (CardView) findViewById(R.id.editBudgetCardViewB);
        budgetList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallEditBudgetActivity();
            }
        });
    }

    private void CallEditBudgetActivity(){
        Intent intent = new Intent(this, EditBudgetActivity.class);
        startActivity(intent);
    }
}
